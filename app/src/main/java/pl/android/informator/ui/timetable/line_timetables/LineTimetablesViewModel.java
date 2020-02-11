package pl.android.informator.ui.timetable.line_timetables;

import android.util.Log;

import androidx.databinding.ListChangeRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.android.informator.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.navigation.Navigator;

public class LineTimetablesViewModel extends BaseViewModel {

    public ObservableInt tramIcon = new ObservableInt();
    public ObservableField<String> tramTitle = new ObservableField<>();
    public ObservableInt busIcon = new ObservableInt();
    public ObservableField<String> busTitle = new ObservableField<>();
    public ObservableField<Navigator> navigator = new ObservableField<>();
    public ObservableField<List<CommunicationLine>> tramList = new ObservableField<>();
    public ObservableField<List<CommunicationLine>> busList = new ObservableField<>();
    public void init(){
       tramIcon.set(R.drawable.ic_tramwajbialy);
       busIcon.set(R.drawable.ic_busik);
       tramTitle.set("Linie tramwajowe");
       busTitle.set("Linie autobusowe");
       navigator.set(getNavigator());
       List<CommunicationLine> tramLines = new ArrayList<>();
       List<BusStop>stops = new ArrayList<>();
       String date1 = "6:32";
       String date2 = "6:48";
       String date3 = "7:04";
       String date4 = "7:20";
       String date5 = "7:36";
       String date6 = "7:52";
       String date7 = "8:08";
       String date8 = "8:24";
       String date9 = "10:00";
       String date10 = "11:00";

       List<Date>dates = new ArrayList<>();
        try {
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date1));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date2));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date3));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date4));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date5));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date6));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date7));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date8));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date9));
            dates.add(new SimpleDateFormat("HH:mm", Locale.US).parse(date10));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        stops.add(new BusStop("Dworzec główny",0,dates,dates,dates,dates));
        stops.add(new BusStop("Plac Bema",2,dates,dates,dates,dates));
        stops.add(new BusStop("Kajki",2,dates,dates,dates,dates));
        stops.add(new BusStop("Mickiewicza",4,dates,dates,dates,dates));
        stops.add(new BusStop("Centrum",6,dates,dates,dates,dates));
        stops.add(new BusStop("Wysoka Brama",8,dates,dates,dates,dates));
        stops.add(new BusStop("Plac Roosevelta",10,dates,dates,dates,dates));
        stops.add(new BusStop("Grunwaldzka",12,dates,dates,dates,dates));
        stops.add(new BusStop("Jezioro Długie",15,dates,dates,dates,dates));
        stops.add(new BusStop("Jeziorna",16,dates,dates,dates,dates));
        stops.add(new BusStop("Zespół Szkół Ekonomicznych",17,dates,dates,dates,dates));
        stops.add(new BusStop("Grabowa",19,dates,dates,dates,dates));
        stops.add(new BusStop("Wędkarska",20,dates,dates,dates,dates));
        stops.add(new BusStop("Letniskowa",21,dates,dates,dates,dates));
        tramLines.add(new CommunicationLine(1,1, "Witosa", "Redykajny",stops));
       tramLines.add(new CommunicationLine(2,2, "Witosa", "Redykajny" ,stops));
       tramLines.add(new CommunicationLine(3,3, "Witosa", "Redykajny",stops));
       List<CommunicationLine> busLines = new ArrayList<>();
       busLines.add(new CommunicationLine(4,101,"Dworzec główny","Redykajny",stops));
       busLines.add(new CommunicationLine(5,103,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(6,105,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(7,106,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(8,101,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(9,103,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(10,105,"Dworzec główny","Redykajny",stops));
        busLines.add(new CommunicationLine(11,106,"Dworzec główny","Redykajny",stops));
        tramList.set(tramLines);
        busList.set(busLines);
    }
}
