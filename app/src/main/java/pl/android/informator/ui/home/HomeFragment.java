package pl.android.informator.ui.home;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.HomeFragmentBinding;
import pl.android.informator.navigation.Navigator;

public class HomeFragment extends BaseFragment<HomeFragmentBinding, HomeViewModel> {

    public static final String TAG = "HomeFragment";

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.home_fragment;
    }

    @Override
    public Class<HomeViewModel> getViewModelClass() {
        return HomeViewModel.class;
    }

    @Override
    public void bindData(HomeFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
    }

    @Override
    public int getToolbarType() {
        return 0;
    }

    @Override
    public int getBackPressType() {
        return 0;
    }

    @Override
    public String getToolbarName() {
        return "costam";
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
    }


    @Override
    public Navigator getNavigator() {
        if((getActivity() !=null))
            return ((MainActivity) getActivity()).navigator;
        return null;
    }

    @Override
    public ViewDataBinding getBinding() {
        if((getActivity() !=null))
            return ((MainActivity)getActivity()).binding;
        return null;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return null;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
