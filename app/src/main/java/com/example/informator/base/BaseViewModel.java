package com.example.informator.base;

import android.app.Activity;
import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public abstract class BaseViewModel extends ViewModel {
    private Providers providers;

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    protected Activity getActivity() {
        return providers.getActivity();
    }
    protected Navigator getNavigator(){
        return providers.getNavigator();
    }
    public ViewDataBinding getBinding(){
        return providers.getBinding();
    }
    public ViewDataBinding getFragmentBinding(){
        return providers.getFragmentBinding();
    }
}
