package pl.android.informator.ui.events;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.EventsFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class EventsFragment extends BaseFragment<EventsFragmentBinding, EventsViewModel> implements Providers {

    public static final String TAG = "EventsFragment";

    public static EventsFragment newInstance() {
        return new EventsFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.events_fragment;
    }

    @Override
    public Class<EventsViewModel> getViewModelClass() {
        return EventsViewModel.class;
    }

    @Override
    public void bindData(EventsFragmentBinding binding) {
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
        return getContext().getString(R.string.events);
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
