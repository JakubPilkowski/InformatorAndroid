package com.example.informator.ui.offers;

import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informator.adapters.offers.OffersAdapter;
import com.example.informator.base.BaseViewModel;
import com.example.informator.models.Offer;

import java.util.ArrayList;
import java.util.List;

public class OffersViewModel extends BaseViewModel {

    public ObservableField<RecyclerView.Adapter>adapter = new ObservableField<>();
    private OffersAdapter offersAdapter = new OffersAdapter();

    public void init() {
        adapter.set(offersAdapter);
        List<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://cdn.x-kom.pl/i/img/banners/normal,,noworoczna-wyprzedaz-2019-2020-x-kom_1577434286.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://cdn.x-kom.pl/i/img/banners/normal,,noworoczna-wyprzedaz-2019-2020-x-kom_1577434286.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://cdn.x-kom.pl/i/img/banners/normal,,noworoczna-wyprzedaz-2019-2020-x-kom_1577434286.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://cdn.x-kom.pl/i/img/banners/normal,,noworoczna-wyprzedaz-2019-2020-x-kom_1577434286.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offerList.add(new Offer("X-KOM","Oferta ogólnopolska","Nowa oferta dla graczy",
                "https://cdn.x-kom.pl/i/img/banners/normal,,noworoczna-wyprzedaz-2019-2020-x-kom_1577434286.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png",
                "Kup jeden produkt, drugi gratis", "https://www.x-kom.pl"));
        offersAdapter.setItems(offerList);
        offersAdapter.setNavigator(getNavigator());
    }
    // TODO: Implement the ViewModel
}
