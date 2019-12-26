package com.example.informator.ui.notice_board;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.NoticeBoardFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class NoticeBoardFragment extends BaseFragment<NoticeBoardFragmentBinding, NoticeBoardViewModel> implements Providers {


    public static final String TAG = "NoticeBoardFragment";
    public static NoticeBoardFragment newInstance() {
        return new NoticeBoardFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.notice_board_fragment;
    }

    @Override
    public Class<NoticeBoardViewModel> getViewModelClass() {
        return NoticeBoardViewModel.class;
    }

    @Override
    public void bindData(NoticeBoardFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
    }

    @Override
    public int getToolbarType() {
        return 1;
    }

    @Override
    public int getBackPressType() {
        return 1;
    }

    @Override
    public String getToolbarName() {
        return "Tablica Ogłoszeń";
    }

    @Override
    public float getToolbarFontSize() {
        return 19;
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
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity)getActivity()).binding;
    }
}
