package pl.android.informator.ui.timetable.line_timetables.single_line;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import com.android.informator.databinding.SingleBusStopBinding;
import com.android.informator.databinding.SingleLineFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.BusStopListener;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.navigation.Navigator;

public class SingleLineFragment extends BaseFragment<SingleLineFragmentBinding,SingleLineViewModel> implements Providers, BusStopListener {
    public static final String TAG = "SingleLineFragment";
    private CommunicationLine line;
    public static SingleLineFragment newInstance(CommunicationLine line) {
        SingleLineFragment fragment = new SingleLineFragment();
        fragment.setLine(line);
        return fragment;
    }


    private void setLine(CommunicationLine line) {
        this.line = line;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.single_line_fragment;
    }

    @Override
    public Class<SingleLineViewModel> getViewModelClass() {
        return SingleLineViewModel.class;
    }

    @Override
    public void bindData(SingleLineFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(line);
        viewModel.setListener(this);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showBusStops(line);
    }

    @Override
    public void showBusStops(CommunicationLine line) {
        ScrollView view = getView().findViewById(R.id.bus_stop_container);
        LinearLayout busContent = getView().findViewById(R.id.bus_stop_content);
        if(busContent!=null)
            busContent.removeAllViews();
        for (int i=0; i<line.getBusStops().size(); i++){
            BusStop stop = line.getBusStops().get(i);
            View busStopView = LayoutInflater.from(getContext()).inflate(R.layout.single_bus_stop,view,false);
            SingleBusStopBinding binding = SingleBusStopBinding.bind(busStopView);
            BusStationViewModel viewModel = new BusStationViewModel();
            binding.setViewModel(viewModel);
            viewModel.init(stop,line,getNavigator());
            busContent.addView(busStopView);
        }

    }
}
