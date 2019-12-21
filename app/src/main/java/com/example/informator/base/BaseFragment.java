package com.example.informator.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.informator.interfaces.Providers;

public abstract class BaseFragment<B extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements Providers {
    public B binding;
    public VM viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutRes(),container,false);
        viewModel = ViewModelProviders.of(this).get(getViewModelClass());
        bindData(binding);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ((BaseActivity) getActivity()).refreshToolbar();
    }

    @LayoutRes
    public abstract int getLayoutRes();

    public abstract Class<VM> getViewModelClass();

    public abstract void bindData(B binding);

    public abstract int getToolbarType();
    // 0 - brak toolbara
    // 1 - toolbar
    public abstract int getBackPressType();
    // 0 - cofnij o jeden
    // 1 - cofnij do menu głównego
}
