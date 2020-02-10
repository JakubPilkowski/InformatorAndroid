package pl.android.informator.ui.timetable.line_timetables;

import android.util.Log;

import androidx.databinding.ListChangeRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.android.informator.R;

import java.util.ArrayList;
import java.util.List;

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
       stops.add(new BusStop("Dworzec główny",0));
        stops.add(new BusStop("Plac Bema",2));
        stops.add(new BusStop("Kajki",2));
        stops.add(new BusStop("Mickiewicza",4));
        stops.add(new BusStop("Centrum",6));
        stops.add(new BusStop("Wysoka Brama",8));
        stops.add(new BusStop("Plac Roosevelta",10));
        stops.add(new BusStop("Grunwaldzka",12));
        stops.add(new BusStop("Jezioro Długie",15));
        stops.add(new BusStop("Jeziorna",16));
        stops.add(new BusStop("Zespół Szkół Ekonomicznych",17));
        stops.add(new BusStop("Grabowa",19));
        stops.add(new BusStop("Wędkarska",20));
        stops.add(new BusStop("Letniskowa",21));
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
