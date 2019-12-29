package com.example.informator.ui.events.event_details;

import androidx.annotation.RequiresApi;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.EventDetailsFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.models.Event;
import com.example.informator.navigation.Navigator;

public class EventDetailsFragment extends BaseFragment<EventDetailsFragmentBinding, EventDetailsViewModel> implements Providers {

    public static final String TAG = "EventDetailsFragment";

    public static EventDetailsFragment newInstance(Event event) {
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragment.setEvent(event);
        return fragment;
    }
    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.event_details_fragment;
    }

    @Override
    public Class<EventDetailsViewModel> getViewModelClass() {
        return EventDetailsViewModel.class;
    }

    @Override
    public void bindData(EventDetailsFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(getEvent());
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
