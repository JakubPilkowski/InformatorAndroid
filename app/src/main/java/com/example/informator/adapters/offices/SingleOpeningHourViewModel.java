package com.example.informator.adapters.offices;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class SingleOpeningHourViewModel extends ViewModel {

    public ObservableField<String> openingHourDay = new ObservableField<>();
    public ObservableField<String>openingHourDate = new ObservableField<>();
    public void init(String key, String value){
        openingHourDay.set(key);
        openingHourDate.set(value);
    }
}
