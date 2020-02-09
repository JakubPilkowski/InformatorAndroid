package pl.android.informator.ui.timetable.line_timetables.single_line;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.interfaces.BusStopListener;
import pl.android.informator.models.CommunicationLine;

public class SingleLineViewModel extends BaseViewModel {
    private BusStopListener listener;
    private CommunicationLine line;
    public ObservableField<String>lineNumber = new ObservableField<>();
    public ObservableField<String>lineName = new ObservableField<>();
    public ObservableField<String>lineDestination = new ObservableField<>();

    public void init(CommunicationLine line){
        this.line = line;
        lineNumber.set(String.valueOf(line.getNumber()));
        lineName.set(line.getFrom());
        lineDestination.set(line.getTo());
    }

    public void setListener(BusStopListener listener) {
        this.listener = listener;
    }

    public void onChangeClick(){
        listener.showBusStops(line);
    }
    public void onShowMapClick(){
        getNavigator().showMap(line);
    }
    // TODO: Implement the ViewModel
}
