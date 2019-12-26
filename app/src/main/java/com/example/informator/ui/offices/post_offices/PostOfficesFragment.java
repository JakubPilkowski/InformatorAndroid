package com.example.informator.ui.offices.post_offices;

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
import com.example.informator.databinding.PostOfficesFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class PostOfficesFragment extends BaseFragment<PostOfficesFragmentBinding, PostOfficesViewModel> implements Providers {

    public static final String TAG = "PostOfficesFragment";

    public static PostOfficesFragment newInstance() {
        return new PostOfficesFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.post_offices_fragment;
    }

    @Override
    public Class<PostOfficesViewModel> getViewModelClass() {
        return PostOfficesViewModel.class;
    }

    @Override
    public void bindData(PostOfficesFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
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
        return "Urzędy Pocztowe";
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
