package com.example.informator.adapters.offers;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.informator.base.BaseAdapterViewModel;
import com.example.informator.models.Offer;
import com.example.informator.navigation.Navigator;

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
    private Offer offer;
    private Navigator navigator;
    @Override
    public void init(Object[] values) {
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
    public void onClick(){
        if(show.get()!=VISIBLE)
            show.set(VISIBLE);
        else
            show.set(GONE);
    }

    public void onLinkClick(){
        navigator.openSite(offer.getSiteUri());
    }
}