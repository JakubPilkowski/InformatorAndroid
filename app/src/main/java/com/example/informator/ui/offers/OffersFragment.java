package com.example.informator.ui.offers;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.OffersFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class OffersFragment extends BaseFragment<OffersFragmentBinding,OffersViewModel> implements Providers {

    public static final String TAG = "OffersFragment";
    public static OffersFragment newInstance() {
        return new OffersFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.offers_fragment;
    }

    @Override
    public Class<OffersViewModel> getViewModelClass() {
        return OffersViewModel.class;
    }

    @Override
    public void bindData(OffersFragmentBinding binding) {
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
        return getContext().getString(R.string.offers);
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
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
