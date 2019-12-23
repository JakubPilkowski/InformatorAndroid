package com.example.informator.ui.offices;

import androidx.databinding.ViewDataBinding;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.OfficesFragmentBinding;
import com.example.informator.navigation.Navigator;

public class OfficesFragment extends BaseFragment<OfficesFragmentBinding,OfficesViewModel> {

    public static final String TAG = "OfficesFragment";

    public static OfficesFragment newInstance() {
        return new OfficesFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.offices_fragment;
    }

    @Override
    public Class<OfficesViewModel> getViewModelClass() {
        return OfficesViewModel.class;
    }

    @Override
    public void bindData(OfficesFragmentBinding binding) {
        binding.setViewModel(viewModel);
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
        return "Urzędy";
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
        return ((MainActivity)getActivity()).binding;
    }

    @Override
    public ViewDataBinding getFragmentBinding() {
        return binding;
    }
}
