package pl.android.informator.ui.offices;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.OfficesFragmentBinding;
import pl.android.informator.navigation.Navigator;

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
        return "Urzędy";
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity)getActivity()).getNavigator();
    }

    @Override
    public ViewDataBinding getBinding() {
        return ((MainActivity)getActivity()).binding;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return binding;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
