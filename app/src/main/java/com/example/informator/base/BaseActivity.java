package com.example.informator.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.informator.navigation.Navigator;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    public Navigator navigator = new Navigator();
    public VM viewModel;
    public B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator.setActivity(this);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().hide();
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        viewModel = ViewModelProviders.of(this).get(getViewModel());
        initActivity(binding);
    }
    public Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentById(getIdFragmentContainer());
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()<=1)
            finish();
        else {
            BaseFragment fragment = (BaseFragment) getCurrentFragment();
            switch (fragment.getBackPressType()){
                case 0:
                    super.onBackPressed();
                    break;
                case 1:

                    break;
            }
        }
    }

    public void refreshToolbar(){
        Fragment fragment = getCurrentFragment();
        if (fragment instanceof BaseFragment){
            if (((BaseFragment) fragment).getToolbarType()==0){
                getSupportActionBar().hide();
            }
            else {
                getSupportActionBar().show();
            }
        }
    }
    protected abstract void initActivity(B binding);

    protected abstract Class<VM> getViewModel();

    public abstract int getIdFragmentContainer();
    @LayoutRes
    public abstract int getLayoutRes();

}
