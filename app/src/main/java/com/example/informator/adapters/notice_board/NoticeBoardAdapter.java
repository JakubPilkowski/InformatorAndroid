package com.example.informator.adapters.notice_board;

import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.base.BaseHeadAndItemRVAdapter;
import com.example.informator.base.BaseViewHolder;
import com.example.informator.databinding.SingleNoticeBoardBinding;
import com.example.informator.databinding.SingleNoticeBoardHeaderBinding;
import com.example.informator.models.Notice;
import com.example.informator.navigation.Navigator;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoardAdapter extends BaseHeadAndItemRVAdapter<Notice, BaseViewHolder,BaseViewHolder> {


    private Navigator navigator;
    private List<NoticeBoardAdapterViewModel> viewModels = new ArrayList<>();
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public BaseViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType, View itemView) {
        SingleNoticeBoardHeaderBinding binding = SingleNoticeBoardHeaderBinding.bind(itemView);
        NoticeBoardHeaderAdapterViewModel viewModel = new NoticeBoardHeaderAdapterViewModel();
        binding.setViewModel(viewModel);
        return new BaseViewHolder(itemView,binding,viewModel);
    }

    @Override
    public int getHeaderLayoutRes() {
        return R.layout.single_notice_board_header;
    }

    @Override
    public void onBindHeaderView(BaseViewHolder holder, int position) {
        holder.setElement(navigator);
    }

    @Override
    public int getItemLayoutRes() {
        return R.layout.single_notice_board;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        SingleNoticeBoardBinding binding = SingleNoticeBoardBinding.bind(itemView);
        return new BaseViewHolder(itemView,binding);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        NoticeBoardAdapterViewModel viewModel;
        if (viewModels.size()<=position){
            viewModel = new NoticeBoardAdapterViewModel();
            viewModels.add(viewModel);
            ((SingleNoticeBoardBinding)holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
            holder.setElement(navigator,items.get(position));
        }
        else{
            viewModel = viewModels.get(position);
            ((SingleNoticeBoardBinding)holder.getBinding()).setViewModel(viewModel);
        }
    }
}
