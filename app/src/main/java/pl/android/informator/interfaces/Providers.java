package pl.android.informator.interfaces;

import android.app.Activity;

import androidx.databinding.ViewDataBinding;

import pl.android.informator.base.BaseFragment;
import pl.android.informator.navigation.Navigator;

public interface Providers {
    Activity getActivity();
    Navigator getNavigator();
    ViewDataBinding getBinding();
    ViewDataBinding getActivityOrFragmentBinding();
    BaseFragment getFragment();
}
