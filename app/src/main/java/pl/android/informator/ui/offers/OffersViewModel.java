package pl.android.informator.ui.offers;

import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.android.informator.databinding.OffersFragmentBinding;

import pl.android.informator.adapters.offers.OffersAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.Offer;

import java.util.ArrayList;
import java.util.List;

public class OffersViewModel extends BaseViewModel {

    public ObservableField<RecyclerView.Adapter>adapter = new ObservableField<>();
    private OffersAdapter offersAdapter = new OffersAdapter();

    public void init() {
        adapter.set(offersAdapter);
        List<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://lpk.x-kom.pl/msi-swiateczna-promocja/images/top.png?",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
//        ((OffersFragmentBinding)getBinding()).postOfficesList.setItemAnimator(null);
        offersAdapter.setItems(offerList);
        offersAdapter.setNavigator(getNavigator());
    }
    // TODO: Implement the ViewModel
}
