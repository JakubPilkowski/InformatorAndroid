package pl.android.informator.ui.timetable.line_timetables.line_details;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import com.android.informator.databinding.LineDetailsFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.navigation.Navigator;

public class LineDetailsFragment extends BaseFragment<LineDetailsFragmentBinding, LineDetailsViewModel> implements Providers {

    public static final String TAG = "LineDetailsFragment";
    private CommunicationLine communicationLine;
    private BusStop stop;

    public static LineDetailsFragment newInstance(BusStop stop, CommunicationLine communicationLine) {
        LineDetailsFragment fragment = new LineDetailsFragment();
        fragment.setLine(communicationLine);
        fragment.setStop(stop);
        return fragment;
    }

    private void setLine(CommunicationLine communicationLine) {
        this.communicationLine = communicationLine;
    }

    private void setStop(BusStop stop) {
        this.stop = stop;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.line_details_fragment;
    }

    @Override
    public Class<LineDetailsViewModel> getViewModelClass() {
        return LineDetailsViewModel.class;
    }

    @Override
    public void bindData(LineDetailsFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(stop, communicationLine);
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
        return "LINIA";
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
