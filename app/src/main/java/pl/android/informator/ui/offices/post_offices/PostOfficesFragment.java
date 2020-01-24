package pl.android.informator.ui.offices.post_offices;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.PostOfficesFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class PostOfficesFragment extends BaseFragment<PostOfficesFragmentBinding, PostOfficesViewModel> implements Providers {

    public static final String TAG = "PostOfficesFragment";

    public static PostOfficesFragment newInstance() {
        return new PostOfficesFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.post_offices_fragment;
    }

    @Override
    public Class<PostOfficesViewModel> getViewModelClass() {
        return PostOfficesViewModel.class;
    }

    @Override
    public void bindData(PostOfficesFragmentBinding binding) {
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
        return "Urzędy Pocztowe";
    }

    @Override
    public float getToolbarFontSize() {
        return 19;
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
