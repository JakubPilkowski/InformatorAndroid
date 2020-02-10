package pl.android.informator.ui.timetable.line_timetables.line_details;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class SingleDepartureTimeMinuteViewModel extends ViewModel {

    public ObservableField<String>minute = new ObservableField<>();

    public void init(String minute){
        this.minute.set(minute);
    }
}
