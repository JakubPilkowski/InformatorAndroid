package com.example.informator.ui.offers;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informator.base.BaseViewModel;

public class OffersViewModel extends BaseViewModel {

    public ObservableField<RecyclerView.Adapter>adapter = new ObservableField<>();


    public void init() {
    }
    // TODO: Implement the ViewModel
}
