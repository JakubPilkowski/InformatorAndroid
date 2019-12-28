package com.example.informator.ui.events;

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
import com.example.informator.databinding.EventsFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class EventsFragment extends BaseFragment<EventsFragmentBinding, EventsViewModel> implements Providers {

    public static final String TAG = "EventsFragment";

    public static EventsFragment newInstance() {
        return new EventsFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.events_fragment;
    }

    @Override
    public Class<EventsViewModel> getViewModelClass() {
        return EventsViewModel.class;
    }

    @Override
    public void bindData(EventsFragmentBinding binding) {
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
        return getContext().getString(R.string.events);
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
