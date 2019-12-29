package com.example.informator.adapters.offices;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.example.informator.R;
import com.example.informator.base.BaseRecyclerViewAdapter;
import com.example.informator.base.BaseViewHolder;
import com.example.informator.databinding.SingleOpeningHourBinding;
import com.example.informator.databinding.SinglePostOfficeBinding;
import com.example.informator.models.PostOffice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
        return new PostOfficesViewHolder(itemView, binding,parent);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        PostOfficesAdapterViewModel viewModel;
        if (viewModels.size() <= position) {
            viewModel = new PostOfficesAdapterViewModel();
            viewModels.add(viewModel);
            ((SinglePostOfficeBinding) holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
            holder.setElement(items.get(position), position);
            ((PostOfficesViewHolder)holder).addViews(items.get(position));
        } else {
            viewModel = viewModels.get(position);
            ((SinglePostOfficeBinding) holder.getBinding()).setViewModel(viewModel);
        }
    }

    private class PostOfficesViewHolder extends BaseViewHolder {

        public ViewGroup parent;
        PostOfficesViewHolder(@NonNull View itemView, ViewDataBinding binding, ViewGroup parent) {
            super(itemView, binding);
            this.parent=parent;
        }

        void addViews(PostOffice postOffice) {
            LinkedHashMap<String, String> openingHours = postOffice.getOpeningHours();
            LinearLayout linearLayout = itemView.findViewById(R.id.post_office_details);
            SingleOpeningHourBinding bindingView;
            SingleOpeningHourViewModel viewModel;
            for (int i = 0; i < openingHours.size(); i++) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_opening_hour,linearLayout,false);
                bindingView = SingleOpeningHourBinding.bind(view);
                viewModel = new SingleOpeningHourViewModel();
                bindingView.setViewModel(viewModel);
                String key = (String) openingHours.keySet().toArray()[i];
                String value = openingHours.get(key);
                viewModel.init(key,value);
                linearLayout.addView(view);
            }
        }

    }
}
