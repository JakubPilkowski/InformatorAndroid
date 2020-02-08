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
       tramLines.add(new CommunicationLine(1,1));
       tramLines.add(new CommunicationLine(2,2));
       tramLines.add(new CommunicationLine(3,3));
       List<CommunicationLine> busLines = new ArrayList<>();
       busLines.add(new CommunicationLine(4,101));
       busLines.add(new CommunicationLine(5,103));
        busLines.add(new CommunicationLine(6,105));
        busLines.add(new CommunicationLine(7,106));
        busLines.add(new CommunicationLine(4,101));
        busLines.add(new CommunicationLine(5,103));
        busLines.add(new CommunicationLine(6,105));
        busLines.add(new CommunicationLine(7,106));
        tramList.set(tramLines);
        busList.set(busLines);
    }
}
