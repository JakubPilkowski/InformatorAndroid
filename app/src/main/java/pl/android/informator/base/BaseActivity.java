package pl.android.informator.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import pl.android.informator.navigation.Navigator;
import pl.android.informator.ui.timetable.set_route.set_route.SetRouteFragment;
import pl.android.informator.ui.timetable.set_route.set_route.SetRouteViewModel;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    public Navigator navigator = new Navigator();
    public VM viewModel;
    public B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator.setActivity(this);
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        viewModel = ViewModelProviders.of(this).get(getViewModel());
        initActivity(binding);
    }

    public BaseFragment getCurrentFragment() {
        return (BaseFragment) getSupportFragmentManager().findFragmentById(getIdFragmentContainer());
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1)
            finish();
        else {
            BaseFragment fragment = getCurrentFragment();
            if (fragment instanceof SetRouteFragment) {
                SetRouteFragment setRouteFragment = (SetRouteFragment) fragment;
                if (setRouteFragment.viewModel.state == setRouteFragment.viewModel.STATE_DEFAULT) {
                    super.onBackPressed();
                }
                else {
                    setRouteFragment.viewModel.onBackPressed();
                }
            } else {
                switch (fragment.getBackPressType()) {
                    case 0:
                        super.onBackPressed();
                        break;
                    case 1:
                        navigator.clearBackStack();
                        break;
                }
            }
        }
    }

    protected abstract void initActivity(B binding);

    protected abstract Class<VM> getViewModel();

    public abstract int getIdFragmentContainer();

    @LayoutRes
    public abstract int getLayoutRes();

}
