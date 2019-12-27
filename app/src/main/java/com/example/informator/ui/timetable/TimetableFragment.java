package com.example.informator.ui.timetable;

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
import com.example.informator.databinding.TimetableFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

import java.sql.Time;

public class TimetableFragment extends BaseFragment<TimetableFragmentBinding, TimetableViewModel> implements Providers {

    public static final String TAG = "TimetableFragment";
    public static TimetableFragment newInstance() {
        return new TimetableFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.timetable_fragment;
    }

    @Override
    public Class<TimetableViewModel> getViewModelClass() {
        return TimetableViewModel.class;
    }

    @Override
    public void bindData(TimetableFragmentBinding binding) {
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
        return getContext().getString(R.string.timetable);
    }

    @Override
    public float getToolbarFontSize() {
        return 18;
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
