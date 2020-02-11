package pl.android.informator.adapters.offers;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import pl.android.informator.base.BaseAdapterViewModel;
import pl.android.informator.models.Offer;
import pl.android.informator.navigation.Navigator;

public class OffersAdapterViewModel extends BaseAdapterViewModel {
    private static final int VISIBLE = 1;
    private static final int GONE = 0;
    private static final int NOTHING = -1;
    public ObservableInt show = new ObservableInt();
    public ObservableField<String> brand = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> imgUrl = new ObservableField<>();
    public ObservableField<String> logoUrl = new ObservableField<>();
    public ObservableField<String> descTitle = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();
    public ObservableInt size = new ObservableInt();
    private Offer offer;
    private Navigator navigator;

    @Override
    public void init(Object[] values) {
        Log.d("init","halo");
        offer = (Offer) values[0];
        navigator = (Navigator) values[1];
        brand.set(offer.getBrand());
        title.set(offer.getTitle());
        imgUrl.set(offer.getImgUrl());
        logoUrl.set(offer.getBrandLogoUrl());
        descTitle.set(offer.getDescTitle());
        desc.set(offer.getDesc());
        show.set(NOTHING);
    }

    public void onClick() {
        if (show.get() != VISIBLE)
            show.set(VISIBLE);
        else
            show.set(GONE);
    }

    public void onLinkClick() {
        navigator.openSite(offer.getSiteUri());
    }

    public void setSize(int size) {
        this.size.set(size);
    }

    void refreshView() {
        if (show.get()==VISIBLE){
            show.set(NOTHING);
            onClick();
        }
    }
}
