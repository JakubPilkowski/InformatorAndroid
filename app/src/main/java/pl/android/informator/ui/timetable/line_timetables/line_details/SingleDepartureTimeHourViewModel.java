package pl.android.informator.ui.timetable.line_timetables.line_details;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class SingleDepartureTimeHourViewModel extends ViewModel {

    public ObservableField<String>hour = new ObservableField<>();
    public void init(String hour){
        this.hour.set(hour+":");
    }
}
