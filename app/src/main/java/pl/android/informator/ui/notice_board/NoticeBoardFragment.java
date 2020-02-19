package pl.android.informator.ui.notice_board;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;

import com.android.informator.databinding.NoticeBoardFragmentBinding;

import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class NoticeBoardFragment extends BaseFragment<NoticeBoardFragmentBinding, NoticeBoardViewModel> implements Providers {


    public static final String TAG = "NoticeBoardFragment";

    public static NoticeBoardFragment newInstance() {
        return new NoticeBoardFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.notice_board_fragment;
    }

    @Override
    public Class<NoticeBoardViewModel> getViewModelClass() {
        return NoticeBoardViewModel.class;
    }

    @Override
    public void bindData(NoticeBoardFragmentBinding binding) {
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
        return "Tablica Ogłoszeń";
    }

    @Override
    public float getToolbarFontSize() {
        return 19;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity) getActivity()).navigator;
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity) getActivity()).binding;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
