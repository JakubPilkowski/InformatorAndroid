package com.example.informator.adapters.offers;

import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.base.BaseRecyclerViewAdapter;
import com.example.informator.base.BaseViewHolder;
import com.example.informator.models.Offers;

public class OffersAdapter extends BaseRecyclerViewAdapter<Offers, BaseViewHolder> {

    @Override
    public int getItemLayoutRes() {
        return R.layout.single_offer;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        return null;
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {

    }
}
