package com.example.informator.ui.notice_board.notice_details;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.NoticeDetailsFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.models.Notice;
import com.example.informator.navigation.Navigator;

public class NoticeDetailsFragment extends BaseFragment<NoticeDetailsFragmentBinding, NoticeDetailsViewModel> implements Providers {

    public static final String TAG = "NoticeDetailsFragment";

    public static NoticeDetailsFragment newInstance(Notice notice) {
        NoticeDetailsFragment fragment = new NoticeDetailsFragment();
        fragment.setNotice(notice);
        return fragment;
    }

    private Notice notice;

    private void setNotice(Notice notice){
        this.notice = notice;
    }

    private Notice getNotice() {
        return notice;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.notice_details_fragment;
    }

    @Override
    public Class<NoticeDetailsViewModel> getViewModelClass() {
        return NoticeDetailsViewModel.class;
    }

    @Override
    public void bindData(NoticeDetailsFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(getNotice());
    }

    @Override
    public int getToolbarType() {
        return 2;
    }

    @Override
    public int getBackPressType() {
        return 0;
    }

    @Override
    public String getToolbarName() {
        return getContext().getString(R.string.notice);
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity)getActivity()).navigator;
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getFragmentBinding() {
        return ((MainActivity)getActivity()).binding;
    }
}
