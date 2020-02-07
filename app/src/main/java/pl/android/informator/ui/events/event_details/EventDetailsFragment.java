package pl.android.informator.ui.events.event_details;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.EventDetailsFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.models.Event;
import pl.android.informator.navigation.Navigator;

public class EventDetailsFragment extends BaseFragment<EventDetailsFragmentBinding, EventDetailsViewModel> implements Providers {

    public static final String TAG = "EventDetailsFragment";

    public static EventDetailsFragment newInstance(Event event) {
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragment.setEvent(event);
        return fragment;
    }
    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.event_details_fragment;
    }

    @Override
    public Class<EventDetailsViewModel> getViewModelClass() {
        return EventDetailsViewModel.class;
    }

    @Override
    public void bindData(EventDetailsFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(getEvent());
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
