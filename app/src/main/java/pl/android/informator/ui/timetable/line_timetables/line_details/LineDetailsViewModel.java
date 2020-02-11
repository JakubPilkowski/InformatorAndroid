package pl.android.informator.ui.timetable.line_timetables.line_details;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.android.informator.R;
import com.android.informator.databinding.LineDetailsFragmentBinding;
import com.android.informator.databinding.SingleDepartureTimeHourBinding;
import com.android.informator.databinding.SingleDepartureTimeMinuteBinding;

import java.util.Date;
import java.util.List;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.DateHelper;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;

public class LineDetailsViewModel extends BaseViewModel {
    private static final int VISIBLE = 1;
    private static final int GONE = 0;
    private static final int NOTHING = -1;
    public ObservableField<String>lineNumber = new ObservableField<>();
    public ObservableField<String>lineChosenBusStation = new ObservableField<>();
    public ObservableField<String>lineDestinationFrom = new ObservableField<>();
    public ObservableField<String>lineDestinationTo = new ObservableField<>();
    public ObservableInt show1 = new ObservableInt();
    public ObservableInt show2 = new ObservableInt();
    public ObservableInt show3 = new ObservableInt();
    public ObservableInt show4 = new ObservableInt();
    public ObservableInt size1 = new ObservableInt();
    public ObservableInt size2 = new ObservableInt();
    public ObservableInt size3 = new ObservableInt();
    public ObservableInt size4 = new ObservableInt();
    private BusStop stop;
    public void init(BusStop stop, CommunicationLine communicationLine){
        this.stop = stop;
        lineNumber.set(String.valueOf(communicationLine.getNumber()));
        lineChosenBusStation.set(stop.getName());
        lineDestinationFrom.set(communicationLine.getFrom());
        lineDestinationTo.set(communicationLine.getTo());
        show1.set(NOTHING);
        show2.set(NOTHING);
        show3.set(NOTHING);
        show4.set(NOTHING);
    }
    public void initHoursView(Context context){
        LinearLayout workingDays = ((LineDetailsFragmentBinding)getBinding()).workingDaysContainer;
        LinearLayout freeFromWorkingDays = ((LineDetailsFragmentBinding)getBinding()).freeDaysFromWorkingContainer;
        LinearLayout saturdays = ((LineDetailsFragmentBinding)getBinding()).saturdaysContainer;
        LinearLayout sundaysAndBreaks = ((LineDetailsFragmentBinding)getBinding()).sundaysAndBreaksContainer;
        createHoursForContainer(workingDays, stop.getWorkingHours(),context,1);
        createHoursForContainer(freeFromWorkingDays, stop.getFreeFromWorkingHours(),context,2);
        createHoursForContainer(saturdays, stop.getSaturdaysHours(),context,3);
        createHoursForContainer(sundaysAndBreaks, stop.getSundaysAndBreaksHours(),context,4);
    }
    private void createHoursForContainer(LinearLayout layout, List<Date> hours, Context context,int type) {
        String currentHour = DateHelper.getHour(hours.get(0));
        LinearLayout singleDepartureTimeHour = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.single_departure_time_hour, layout, false);
        LinearLayout minutesContainer = singleDepartureTimeHour.findViewById(R.id.single_departure_time_minutes_container);
        LinearLayout singleDepartureTimeMinute;
        SingleDepartureTimeMinuteBinding singleDepartureTimeMinuteBinding;
        SingleDepartureTimeHourBinding singleDepartureTimeHourBinding = SingleDepartureTimeHourBinding.bind(singleDepartureTimeHour);
        SingleDepartureTimeHourViewModel singleDepartureTimeHourViewModel = new SingleDepartureTimeHourViewModel();
        singleDepartureTimeHourBinding.setViewModel(singleDepartureTimeHourViewModel);
        singleDepartureTimeHourViewModel.init(currentHour);
        int currentLabel = 1;
        minutesContainer.setBackgroundResource(R.color.colorTextBlack);
        for (int i = 0; i < hours.size(); i++) {
            String hour = DateHelper.getHour(hours.get(i));
            if (!hour.equals(currentHour)) {
                currentLabel++;
                layout.addView(singleDepartureTimeHour);
                currentHour = hour;
                singleDepartureTimeHour = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.single_departure_time_hour, layout, false);
                singleDepartureTimeHourBinding = SingleDepartureTimeHourBinding.bind(singleDepartureTimeHour);
                singleDepartureTimeHourViewModel = new SingleDepartureTimeHourViewModel();
                singleDepartureTimeHourBinding.setViewModel(singleDepartureTimeHourViewModel);
                singleDepartureTimeHourViewModel.init(currentHour);
                minutesContainer = singleDepartureTimeHour.findViewById(R.id.single_departure_time_minutes_container);
                if (currentLabel%2==0){
                    minutesContainer.setBackgroundResource(R.color.colorGray2);
                }
                else {
                    minutesContainer.setBackgroundResource(R.color.colorTextBlack);
                }
            }
            singleDepartureTimeMinute = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.single_departure_time_minute, layout, false);
            singleDepartureTimeMinuteBinding = SingleDepartureTimeMinuteBinding.bind(singleDepartureTimeMinute);
            SingleDepartureTimeMinuteViewModel singleDepartureTimeMinuteViewModel = new SingleDepartureTimeMinuteViewModel();
            singleDepartureTimeMinuteBinding.setViewModel(singleDepartureTimeMinuteViewModel);
            singleDepartureTimeMinuteViewModel.init(DateHelper.getMinute(hours.get(i)));
            minutesContainer.addView(singleDepartureTimeMinute);
        }
        layout.addView(singleDepartureTimeHour);
        setSize(32*currentLabel,type);
    }
    public void onWorkingDaysClick(){
        if(show1.get()!=VISIBLE)
            show1.set(VISIBLE);
        else
            show1.set(GONE);
    }

    public void onFreeDaysFromWorkingClick(){
        if(show2.get()!=VISIBLE)
            show2.set(VISIBLE);
        else
            show2.set(GONE);
    }

    private void setSize(int size, int type) {
        switch (type){
            case 1:
                size1.set(size);
                break;
            case 2:
                size2.set(size);
                break;
            case 3:
                size3.set(size);
                break;
            case 4:
                size4.set(size);
        }
    }

    public void onSaturdayClick(){
        if(show3.get()!=VISIBLE)
            show3.set(VISIBLE);
        else
            show3.set(GONE);
    }

    public void onSundayAndBreaks(){
        if(show4.get()!=VISIBLE)
            show4.set(VISIBLE);
        else
            show4.set(GONE);
    }

}
