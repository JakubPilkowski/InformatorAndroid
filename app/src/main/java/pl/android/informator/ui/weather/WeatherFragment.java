package pl.android.informator.ui.weather;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.WeatherFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;

public class WeatherFragment extends BaseFragment<WeatherFragmentBinding, WeatherViewModel> implements Providers {


    public static String TAG = "WeatherFragment";
    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.weather_fragment;
    }

    @Override
    public Class<WeatherViewModel> getViewModelClass() {
        return WeatherViewModel.class;
    }

    @Override
    public void bindData(WeatherFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                viewModel.setMainImage();
            }
        }).start();
    }
    @Override
    public int getToolbarType() {
        return 0;
    }

    @Override
    public int getBackPressType() {
        return 1;
    }

    @Override
    public String getToolbarName() {
        return getContext().getString(R.string.weather);
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
