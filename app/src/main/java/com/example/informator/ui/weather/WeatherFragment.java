package com.example.informator.ui.weather;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
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
import com.example.informator.databinding.WeatherFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class WeatherFragment extends BaseFragment<WeatherFragmentBinding, WeatherViewModel> implements Providers {


    public static String TAG = "WeatherFragment";
    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.weather_fragment;
    }

    @Override
    public Class<WeatherViewModel> getViewModelClass() {
        return WeatherViewModel.class;
    }

    @Override
    public void bindData(WeatherFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
    }

    @Override
    public int getToolbarType() {
        return 0;
    }

    @Override
    public int getBackPressType() {
        return 1;
    }

    @Override
    public String getToolbarName() {
        return getContext().getString(R.string.weather);
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
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity)getActivity()).binding;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
