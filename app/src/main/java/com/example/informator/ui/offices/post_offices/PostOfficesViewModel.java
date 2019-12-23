package com.example.informator.ui.offices.post_offices;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informator.adapters.PostOfficesListAdapter;
import com.example.informator.base.BaseViewModel;
import com.example.informator.models.PostOffice;

import java.util.ArrayList;
import java.util.List;

public class PostOfficesViewModel extends BaseViewModel {
    public ObservableField<RecyclerView.Adapter>adapter = new ObservableField<>();
    private PostOfficesListAdapter postOfficesListAdapter = new PostOfficesListAdapter();
    public void init() {
        adapter.set(postOfficesListAdapter);
        List<PostOffice>postOffices = new ArrayList<>();
//        postOfficesListAdapter.setItems();
    }

    // TODO: Implement the ViewModel
}
