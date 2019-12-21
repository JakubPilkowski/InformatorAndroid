package com.example.informator.base;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

import com.example.informator.interfaces.Providers;

public abstract class BaseViewModel extends ViewModel {
    Providers providers;

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    public Activity getActivity() {
        return providers.getActivity();
    }
}
