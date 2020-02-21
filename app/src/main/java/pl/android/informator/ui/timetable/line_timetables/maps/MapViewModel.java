package pl.android.informator.ui.timetable.line_timetables.maps;

import android.preference.PreferenceManager;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.android.informator.databinding.MapFragmentBinding;

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
        lineName.set(line.getTo());
        MapView mapView = ((MapFragmentBinding)getBinding()).osmMapView;
        mapView.setMultiTouchControls(true);
        IMapController mapController = mapView.getController();
        mapController.setZoom(9.5);
        GeoPoint startPoint = new GeoPoint(48.8583, 2.2944);
        mapController.setCenter(startPoint);
    }
}
