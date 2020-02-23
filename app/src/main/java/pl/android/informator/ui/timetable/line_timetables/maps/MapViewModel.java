package pl.android.informator.ui.timetable.line_timetables.maps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.preference.PreferenceManager;

import com.android.informator.R;
import com.android.informator.databinding.MapFragmentBinding;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polygon;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.CommunicationLine;

public class MapViewModel extends BaseViewModel implements LocationListener {
    // TODO: Implement the ViewModel4
    public ObservableField<String> lineNumber = new ObservableField<>();
    public ObservableField<String> lineDestination = new ObservableField<>();
    public ObservableField<String> lineName = new ObservableField<>();
    private MapView mapView;
    private LocationManager locationManager;
    private List<OverlayItem> mStartGoalItems = new ArrayList<>();
    private IMapController mapController;

    public void init(CommunicationLine line) {
        lineNumber.set(String.valueOf(line.getNumber()));
        lineName.set(line.getFrom());
        lineDestination.set(line.getTo());
        Configuration.getInstance().load(getActivity().getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(
                getActivity().getApplicationContext()));

        mapView = ((MapFragmentBinding) getBinding()).osmMapView;

        mapController = mapView.getController();
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);

//        GeoPoint startPoint = new GeoPoint( 53.78441739158615, 20.498394209024823);
//        GeoPoint endPoint = new GeoPoint(53.80980321476357, 20.43932119204561);
//        OverlayItem startItem = new OverlayItem("", "", startPoint);
//        Drawable newMarker = mapView.getContext().getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp);
////        startItem.setMarker(newMarker);
//        mStartGoalItems.add(startItem);
//
//        OverlayItem goalItem = new OverlayItem("", "", endPoint);
//        Drawable newMarker2 = mapView.getContext().getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp);
//        goalItem.setMarker(newMarker2);
//        mStartGoalItems.add(goalItem);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MainActivity.RESULT_ACCESS_FINE_LOCATION);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this);
            initMap();
        }

    }

    public void initMap() {

        final RoadManager roadManager = new OSRMRoadManager(mapView.getContext());
        final ArrayList<GeoPoint> pts = new ArrayList<>();
        GeoPoint startPoint = new GeoPoint(53.78441739158615, 20.498394209024823);
        GeoPoint point2 = new GeoPoint(53.78346381381083,20.491053279614473);
        GeoPoint point3 = new GeoPoint(53.782810870608046, 20.488081661273633);
        GeoPoint point4 = new GeoPoint(53.779488672322515, 20.487450942276684);
        GeoPoint point5 = new GeoPoint( 53.77793856842446, 20.482316847394653);
        GeoPoint point6 = new GeoPoint(53.77744089490557,20.478250554638784);
        GeoPoint point7 = new GeoPoint(53.773567012932666, 20.475327286794833);
        GeoPoint point8 = new GeoPoint( 53.776128495607566,20.469437043991885);
        GeoPoint point9 = new GeoPoint(53.77862325096494,20.463359233662185);
        GeoPoint endPoint = new GeoPoint(53.80980321476357, 20.43932119204561);
        pts.add(startPoint);
        pts.add(point2);
        pts.add(point3);
        pts.add(point4);
        pts.add(point5);
        pts.add(point6);
        pts.add(point7);
        pts.add(point8);
        pts.add(point9);
        pts.add(endPoint);

        new AsyncTask<Void, Void, Road>() {
            @Override
            protected Road doInBackground(Void... voids) {
                Road road = roadManager.getRoad(pts);
                return road;
            }

            @Override
            protected void onPostExecute(Road road) {
                super.onPostExecute(road);
                if (road.mStatus != Road.STATUS_OK) {
                    Log.d("halo", "onPostExecute: " + road.mStatus);
                }
                Polyline roadOverlay = RoadManager.buildRoadOverlay(road, getActivity().getResources()
                        .getColor(R.color.colorGradientStart), 12);
                roadOverlay.setGeodesic(true);
                roadOverlay.setPoints(pts);
                mapView.getOverlays().add(roadOverlay);
                for (GeoPoint point:pts) {
                    Marker startMarker = new Marker(mapView);
                    startMarker.setPosition(point);
                    startMarker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_CENTER);
                    startMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker, MapView mapView) {
                            return true;
                        }
                    });
                    if (point == pts.get(0))
                        startMarker.setIcon(getActivity().getResources().getDrawable(R.drawable.bus_station_start_marker_orange));
                    if (point==pts.get(pts.size()-1))
                        startMarker.setIcon(getActivity().getResources().getDrawable(R.drawable.bus_station_end_marker_orange));
                    if(point!=pts.get(0) && point!=pts.get(pts.size()-1))
                        startMarker.setIcon(getActivity().getResources().getDrawable(R.drawable.bus_station_marker_orange));
                    mapView.getOverlays().add(startMarker);
                    mapView.invalidate();

                }
            }
        }.execute();


        mapController.setZoom(13.5d);
        mapController.setCenter(startPoint);
    }

    public void onLocationChanged(Location location) {

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
    public void onShowLineClick(){
        getActivity().onBackPressed();
    }
}
