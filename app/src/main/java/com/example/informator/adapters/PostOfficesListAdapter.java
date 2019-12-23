package com.example.informator.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.base.BaseRecyclerViewAdapter;
import com.example.informator.base.BaseViewHolder;
import com.example.informator.databinding.SinglePostOfficeBinding;
import com.example.informator.models.PostOffice;

import java.util.ArrayList;
import java.util.List;

public class PostOfficesListAdapter extends BaseRecyclerViewAdapter<PostOffice, BaseViewHolder> {

    private List<PostOfficesAdapterViewModel> viewModels = new ArrayList<>();

    @Override
    public int getItemLayoutRes() {
        return R.layout.single_post_office;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        SinglePostOfficeBinding binding = SinglePostOfficeBinding.bind(itemView);
        return new BaseViewHolder(itemView,binding);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        PostOfficesAdapterViewModel viewModel;
        if(viewModels.size()<=position) {
            viewModel = new PostOfficesAdapterViewModel();
            viewModels.add(viewModel);
            ((SinglePostOfficeBinding)holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
            holder.setElement(items.get(position));
        }
        else{
            viewModel = viewModels.get(position);
            ((SinglePostOfficeBinding)holder.getBinding()).setViewModel(viewModel);
        }
    }
}
