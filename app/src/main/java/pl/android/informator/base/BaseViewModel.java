package pl.android.informator.base;

import android.app.Activity;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

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
    public BaseFragment getFragment(){return providers.getFragment();}
    public ViewDataBinding getFragmentBinding(){
        return providers.getActivityOrFragmentBinding();
    }
}
