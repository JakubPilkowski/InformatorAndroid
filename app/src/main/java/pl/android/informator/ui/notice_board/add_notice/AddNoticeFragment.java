package pl.android.informator.ui.notice_board.add_notice;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.AddNoticeFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

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
