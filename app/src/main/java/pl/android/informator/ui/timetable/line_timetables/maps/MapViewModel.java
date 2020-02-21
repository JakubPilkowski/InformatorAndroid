package pl.android.informator.ui.timetable.line_timetables.maps;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.preference.PreferenceManager;

import com.android.informator.databinding.MapFragmentBinding;

import org.metalev.multitouch.controller.MultiTouchController;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.CommunicationLine;

public class MapViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel4
    public ObservableField<String> lineNumber = new ObservableField<>();
    public ObservableField<String>  lineDestination= new ObservableField<>();
    public ObservableField<String> lineName = new ObservableField<>();
    public void init(CommunicationLine line){
//        Configuration.getInstance().load(getActivity().getApplicationContext(), PreferenceManager.getDe);
        lineNumber.set(String.valueOf(line.getNumber()));
        lineName.set(line.getFrom());
        lineDestination.set(line.getTo());
        MapView mapView = ((MapFragmentBinding)getBinding()).osmMapView;
        Configuration.getInstance().load(getActivity().getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(
                getActivity().getApplicationContext()));
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);
        IMapController mapController = mapView.getController();
        mapController.setZoom(15d);
        mapView.setMinZoomLevel(15d);
        GeoPoint startPoint = new GeoPoint(53.7799500, 20.4941600);
        GeoPoint endPoint = new GeoPoint(53.7799000,20.4941500);
        startPoint.distanceToAsDouble(endPoint);
        mapController.setCenter(startPoint);
    }
}
