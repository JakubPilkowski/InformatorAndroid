package com.example.informator.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    public VM viewModel;
    public B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        viewModel = ViewModelProviders.of(this).get(getViewModel());
        initActivity(binding);
    }
    public Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentById(getIdFragmentContainer());
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==1)
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
