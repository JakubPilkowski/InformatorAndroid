package pl.android.informator.ui.timetable.line_timetables.maps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.preference.PreferenceManager;

import com.android.informator.R;
import com.android.informator.databinding.MapFragmentBinding;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.CommunicationLine;

public class MapViewModel extends BaseViewModel implements LocationListener{
    // TODO: Implement the ViewModel4
    public ObservableField<String> lineNumber = new ObservableField<>();
    public ObservableField<String> lineDestination = new ObservableField<>();
    public ObservableField<String> lineName = new ObservableField<>();
    private MapView mapView;
    private LocationManager locationManager;
    private List<OverlayItem> mStartGoalItems = new ArrayList<>();
    private IMapController mapController ;
    public void init(CommunicationLine line) {
        lineNumber.set(String.valueOf(line.getNumber()));
        lineName.set(line.getFrom());
        lineDestination.set(line.getTo());
        Configuration.getInstance().load(getActivity().getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(
                getActivity().getApplicationContext()));

        mapView = ((MapFragmentBinding) getBinding()).osmMapView;
//        MyLocationNewOverlay locationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getActivity().getApplicationContext()),mapView);
//        locationOverlay.enableMyLocation();
//        mapView.getOverlays().add(locationOverlay);

        mapController = mapView.getController();
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);

        GeoPoint startPoint = new GeoPoint( 53.78441739158615, 20.498394209024823);
        GeoPoint endPoint = new GeoPoint(53.80980321476357, 20.43932119204561);
        //        GeoPoint endPoint = new GeoPoint(53.7799000,20.4941500);
//        startPoint.distanceToAsDouble(endPoint);
//        mapController.setCenter(startPoint);
        OverlayItem startItem = new OverlayItem("", "", startPoint);
        Drawable newMarker = mapView.getContext().getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp);
//        startItem.setMarker(newMarker);
        mStartGoalItems.add(startItem);

        OverlayItem goalItem = new OverlayItem("", "", endPoint);
        Drawable newMarker2 = mapView.getContext().getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp);
//        goalItem.setMarker(newMarker2);
        mStartGoalItems.add(goalItem);

        //        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MainActivity.RESULT_ACCESS_FINE_LOCATION);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this);
            initMap();
        }

    }

    public void initMap() {
        //mOsmPathOverlay = new OsmPathOverlay(context);
        //mMapView.getOverlayManager().add(mOsmPathOverlay);
        Polyline line = new Polyline(mapView);
        line.setTitle("Central Park, NYC");
        line.setSubDescription(Polyline.class.getCanonicalName());
        List<GeoPoint> pts = new ArrayList<>();
        //here, we create a polygon, note that you need 5 points in order to make a closed polygon (rectangle)
        GeoPoint startPoint = new GeoPoint( 53.78441739158615, 20.498394209024823);
        GeoPoint endPoint = new GeoPoint(53.80980321476357, 20.43932119204561);
        pts.add(startPoint);
        pts.add(endPoint);
        line.setPoints(pts);
        line.setGeodesic(true);
        line.setInfoWindow(new BasicInfoWindow(R.layout.bonuspack_bubble, mapView));
        //Note, the info window will not show if you set the onclick listener
        //line can also attach click listeners to the line
        /*
        line.setOnClickListener(new Polyline.OnClickListener() {
            @Override
            public boolean onClick(Polyline polyline, MapView mapView, GeoPoint eventPos) {
                Toast.makeText(context, "Hello world!", Toast.LENGTH_LONG).show();
                return false;
            }
        });*/
        mapController.setZoom(13.5d);
        mapController.setCenter(startPoint);
        mapView.getOverlayManager().add(line);
//        mapView.getOverlays().add(new ItemizedIconOverlay<>(mStartGoalItems,
//                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
//                    @Override
//                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean onItemLongPress(int index, OverlayItem item) {
//                        return false;
//                    }
//
//                }, mapView.getContext()));
        mapView.invalidate();
    }

    @Override
    public void onLocationChanged(Location location) {
//        int lat = (int) (location.getLatitude() * 1E6);
//        int lng = (int) (location.getLongitude() * 1E6);
//        GeoPoint gpt = new GeoPoint(lat, lng);
//        mapController.setCenter(gpt);
//        mMapView.invalidate();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
