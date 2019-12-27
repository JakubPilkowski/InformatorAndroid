package com.example.informator.adapters.offers;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableShort;

import com.example.informator.base.BaseAdapterViewModel;

public class OffersAdapterViewModel extends BaseAdapterViewModel {

    public ObservableInt show = new ObservableInt();
    public ObservableField<String> brand = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> imgUrl = new ObservableField<>();
    public ObservableField<String> logoUrl = new ObservableField<>();

    @Override
    public void init(Object[] values) {

    }
    public void onClick(){

    }
}
