package com.example.informator.adapters;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.informator.base.BaseAdapterViewModel;
import com.example.informator.models.PostOffice;

public class PostOfficesAdapterViewModel extends BaseAdapterViewModel {
    private static final int VISIBLE = 1;
    private static final int GONE = 0;
    private static final int NOTHING = -1;
    public ObservableField<String>title = new ObservableField<>();
    public ObservableField<String>subtitle = new ObservableField<>();
    public ObservableField<String>url = new ObservableField<>();
    public ObservableInt show = new ObservableInt();
    public ObservableField<String>postalCode = new ObservableField<>();
    public ObservableField<String>phone = new ObservableField<>();


    @Override
    public void init(Object[] values) {
        PostOffice postOffice = (PostOffice) values[0];
        int position = (int) values[1];
        title.set("Urząd Pocztowy NR."+(position+1));
        subtitle.set(postOffice.getStreet());
        url.set(postOffice.getImgUrl());
        postalCode.set(postOffice.getPostalCode());
        phone.set(String.valueOf(postOffice.getPhoneNumber()));
        show.set(NOTHING);
    }
    public void onClick(){
        if(show.get()!=VISIBLE)
            show.set(VISIBLE);
        else
            show.set(GONE);
    }
}
