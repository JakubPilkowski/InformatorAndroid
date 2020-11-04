package pl.android.informator.ui.timetable.set_route.set_route;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import com.android.informator.databinding.SetRouteFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class SetRouteFragment extends BaseFragment<SetRouteFragmentBinding,SetRouteViewModel> implements Providers {

    public static final String TAG = "SetRouteFragment";

    public static SetRouteFragment newInstance() {
        return new SetRouteFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.set_route_fragment;
    }

    @Override
    public Class<SetRouteViewModel> getViewModelClass() {
        return SetRouteViewModel.class;
    }

    @Override
    public void bindData(SetRouteFragmentBinding binding) {
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
        return getResources().getString(R.string.set_route);
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
