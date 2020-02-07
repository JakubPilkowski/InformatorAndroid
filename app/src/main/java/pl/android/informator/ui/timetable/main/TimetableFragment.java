package pl.android.informator.ui.timetable.main;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.TimetableFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class TimetableFragment extends BaseFragment<TimetableFragmentBinding, TimetableViewModel> implements Providers {

    public static final String TAG = "TimetableFragment";
    public static TimetableFragment newInstance() {
        return new TimetableFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.timetable_fragment;
    }

    @Override
    public Class<TimetableViewModel> getViewModelClass() {
        return TimetableViewModel.class;
    }

    @Override
    public void bindData(TimetableFragmentBinding binding) {
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
        return getContext().getString(R.string.timetable);
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
