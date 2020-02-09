package pl.android.informator.ui.timetable.line_timetables.line_details;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;

public class LineDetailsViewModel extends BaseViewModel {
    public ObservableField<String>lineNumber = new ObservableField<>();
    public ObservableField<String>lineChosenBusStation = new ObservableField<>();
    public ObservableField<String>lineDestinationFrom = new ObservableField<>();
    public ObservableField<String>lineDestinationTo = new ObservableField<>();
    public ObservableInt show = new ObservableInt();
    public void init(BusStop stop, CommunicationLine communicationLine){
        lineNumber.set(String.valueOf(communicationLine.getNumber()));
        lineChosenBusStation.set(stop.getName());
        lineDestinationFrom.set(communicationLine.getFrom());
        lineDestinationTo.set(communicationLine.getTo());
    }

    public void onWorkingDaysClick(){

    }

    public void onFreeDaysFromWorkingClick(){

    }

    public void onSaturdayClick(){

    }

    public void onSundayAndBreaks(){

    }

}
