package com.example.informator.ui.notice_board.add_notice;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.databinding.ViewDataBinding;

import com.example.informator.R;
import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.AddNoticeFragmentBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;

public class AddNoticeFragment extends BaseFragment<AddNoticeFragmentBinding, AddNoticeViewModel> implements Providers {
    public static final String TAG = "AddNoticeFragment";

    public static AddNoticeFragment newInstance() {
        return new AddNoticeFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.add_notice_fragment;
    }

    @Override
    public Class<AddNoticeViewModel> getViewModelClass() {
        return AddNoticeViewModel.class;
    }

    @Override
    public void bindData(AddNoticeFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
    }

    @Override
    public int getToolbarType() {
        return 2;
    }

    @Override
    public int getBackPressType() {
        return 0;
    }

    @Override
    public String getToolbarName() {
        return getContext().getString(R.string.add_notice);
    }

    @Override
    public float getToolbarFontSize() {
        return 18;
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
