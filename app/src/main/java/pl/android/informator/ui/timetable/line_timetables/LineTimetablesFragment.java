package pl.android.informator.ui.timetable.line_timetables;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.android.informator.R;
import com.android.informator.databinding.LineTimetablesFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class LineTimetablesFragment extends BaseFragment<LineTimetablesFragmentBinding, LineTimetablesViewModel> implements Providers {

    public static final String TAG = "LineTimetablesFragment";
    public static LineTimetablesFragment newInstance() {
        return new LineTimetablesFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.line_timetables_fragment;
    }

    @Override
    public Class<LineTimetablesViewModel> getViewModelClass() {
        return LineTimetablesViewModel.class;
    }

    @Override
    public void bindData(LineTimetablesFragmentBinding binding) {
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
        return "ROZKŁADY LINII";
    }

    @Override
    public float getToolbarFontSize() {
        return 18;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity)getActivity()).getNavigator();
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity)getActivity()).getBinding();
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
