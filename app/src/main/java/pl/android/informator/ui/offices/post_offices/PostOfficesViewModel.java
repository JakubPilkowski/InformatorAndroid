package pl.android.informator.ui.offices.post_offices;

import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import pl.android.informator.adapters.offices.PostOfficesListAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.PostOffice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PostOfficesViewModel extends BaseViewModel {
    public ObservableField<RecyclerView.Adapter>adapter = new ObservableField<>();
    private PostOfficesListAdapter postOfficesListAdapter = new PostOfficesListAdapter();
    public void init() {
        adapter.set(postOfficesListAdapter);
        List<PostOffice>postOffices = new ArrayList<>();
        LinkedHashMap<String, String> godzinyOtwarcia1 = new LinkedHashMap<>();
        godzinyOtwarcia1.put("Poniedziałek","7:00 - 19:00");
        godzinyOtwarcia1.put("Wtorek-Czwartek","7:00 - 20:00");
        godzinyOtwarcia1.put("Piątek","8:00 - 20:00");
        LinkedHashMap<String, String> godzinyOtwarcia2 = new LinkedHashMap<>();
        godzinyOtwarcia2.put("Poniedziałek-Piątek","7:00 - 19:00");
        postOffices.add(new PostOffice("Pieniężnego 28","https://bi.im-g.pl/im/6a/d4/d3/z13882474V,Poczta-przy-ul--Pienieznego-w-Olsztynie.jpg"
        ,"10-001",123456789,godzinyOtwarcia1));
        postOffices.add(new PostOffice("Partyzantów 39","https://bi.im-g.pl/im/6a/d4/d3/z13882474V,Poczta-przy-ul--Pienieznego-w-Olsztynie.jpg"
                ,"10-504",879521212,godzinyOtwarcia2));
        postOffices.add(new PostOffice("Partyzantów 39","https://bi.im-g.pl/im/6a/d4/d3/z13882474V,Poczta-przy-ul--Pienieznego-w-Olsztynie.jpg"
                ,"10-504",879521212,godzinyOtwarcia2));
        postOffices.add(new PostOffice("Partyzantów 39","https://bi.im-g.pl/im/6a/d4/d3/z13882474V,Poczta-przy-ul--Pienieznego-w-Olsztynie.jpg"
                ,"10-504",879521212,godzinyOtwarcia2));
        postOfficesListAdapter.setItems(postOffices);
    }

    // TODO: Implement the ViewModel
}
