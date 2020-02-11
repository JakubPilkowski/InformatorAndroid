package pl.android.informator.ui.timetable.line_timetables.single_line;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.navigation.Navigator;

public class BusStationViewModel extends ViewModel {
    private CommunicationLine line;
    private Navigator navigator;
    private BusStop stop;
    public ObservableField<String>timeFromStart = new ObservableField<>();
    public ObservableField<String>busStationName = new ObservableField<>();

    public void init(BusStop stop, CommunicationLine line, Navigator navigator){
        this.stop = stop;
        this.line = line;
        this.navigator = navigator;
        timeFromStart.set(stop.getTimeFromStart()+"'");
        busStationName.set(String.valueOf(stop.getName()));
    }

    public void onClick(){
        navigator.showLineDetails(stop, line);
    }
}
