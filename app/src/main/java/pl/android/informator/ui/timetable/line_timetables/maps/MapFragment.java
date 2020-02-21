package pl.android.informator.ui.timetable.line_timetables.maps;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.android.informator.R;
import com.android.informator.databinding.MapFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.navigation.Navigator;

public class MapFragment extends BaseFragment<MapFragmentBinding, MapViewModel> implements Providers {

    public static final String TAG = "MapFragment";
    private CommunicationLine line;

    public static MapFragment newInstance(CommunicationLine line) {
        MapFragment fragment = new MapFragment();
        fragment.setCommunicationLine(line);
        return fragment;
    }

    private void setCommunicationLine(CommunicationLine line) {
        this.line = line;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.osmMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.osmMapView.onPause();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.map_fragment;
    }

    @Override
    public Class<MapViewModel> getViewModelClass() {
        return MapViewModel.class;
    }

    @Override
    public void bindData(MapFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(line);
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
        return getResources().getString(R.string.route_map);
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity) getActivity()).navigator;
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity) getActivity()).binding;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
