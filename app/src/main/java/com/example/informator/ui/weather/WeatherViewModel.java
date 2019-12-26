package com.example.informator.ui.weather;

import android.widget.ImageView;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseViewModel;
import com.example.informator.databinding.ActivityMainBinding;
import com.example.informator.databinding.WeatherFragmentBinding;
import com.example.informator.models.Weather;

import java.util.Random;

public class WeatherViewModel extends BaseViewModel {


    public ObservableField<String>temp = new ObservableField<>();
    public ObservableField<String>weatherType = new ObservableField<>();
    public ObservableField<String>humidity = new ObservableField<>();
    public ObservableField<String>pressure = new ObservableField<>();
    public ObservableField<String>weatherTypeTomorrow = new ObservableField<>();
    public ObservableField<String>tempTomorrow = new ObservableField<>();
    public ObservableField<String>maxTempTomorrow = new ObservableField<>();
    public ObservableField<String>weatherTypeOvermorrow = new ObservableField<>();
    public ObservableField<String>tempOvermorrow = new ObservableField<>();
    public ObservableField<String>maxTempOvermorrow = new ObservableField<>();

    public void init() {
        ((MainActivity)getActivity()).setSupportActionBar(((WeatherFragmentBinding)getBinding()).toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(getFragment().getWhiteBurger());
        Weather weather1;
        Weather weather2;
        Weather weather3;
        int rand = new Random().nextInt(10);
        switch (rand){
            case 1:
//                weather1 = new Weather("36")
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:

        }

    }
    // TODO: Implement the ViewModel
}
