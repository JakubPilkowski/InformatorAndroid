package com.example.informator.interfaces;

import android.app.Activity;

import androidx.databinding.ViewDataBinding;

import com.example.informator.base.BaseFragment;
import com.example.informator.navigation.Navigator;

public interface Providers {
    Activity getActivity();
    Navigator getNavigator();
    ViewDataBinding getBinding();
    ViewDataBinding getActivityOrFragmentBinding();
    BaseFragment getFragment();
}
