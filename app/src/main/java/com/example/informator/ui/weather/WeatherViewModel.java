package com.example.informator.ui.weather;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseViewModel;
import com.example.informator.databinding.WeatherFragmentBinding;
import com.example.informator.models.Weather;

import java.util.Random;

public class WeatherViewModel extends BaseViewModel {


    public ObservableField<String> temp = new ObservableField<>();
    public ObservableField<String> weatherType = new ObservableField<>();
    public ObservableField<String> humidity = new ObservableField<>();
    public ObservableField<String> pressure = new ObservableField<>();
    public ObservableField<String> weatherTypeTomorrow = new ObservableField<>();
    public ObservableField<String> tempTomorrow = new ObservableField<>();
    public ObservableField<String> maxTempTomorrow = new ObservableField<>();
    public ObservableField<String> weatherTypeOvermorrow = new ObservableField<>();
    public ObservableField<String> tempOvermorrow = new ObservableField<>();
    public ObservableField<String> maxTempOvermorrow = new ObservableField<>();

    public void init() {
        ((MainActivity) getActivity()).setSupportActionBar(((WeatherFragmentBinding) getBinding()).toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(getFragment().getWhiteBurger());
        Weather weather1;
        Weather weather2;
        Weather weather3;
        int rand = new Random().nextInt(8);
        switch (rand) {
            case 0:
                weather1 = new Weather("36", "40", Weather.SLONCE, "10%", "1000hPa");
                weather2 = new Weather("22", "24", Weather.DESZCZ, "50%", "990hPa");
                weather3 = new Weather("22", "23", Weather.BURZA, "70%", "995hPa");
                break;
            case 1:
                weather1 = new Weather("15", "17", Weather.MZAWKA, "35%", "993hPa");
                weather2 = new Weather("10", "11", Weather.MGLA, "100%", "1001hPa");
                weather3 = new Weather("14", "16", Weather.CZESCIOWE_ZACHMURZENIE, "70%", "999hPa");
                break;
            case 2:
                weather1 = new Weather("33", "36", Weather.SLONCE, "10%", "1000hPa");
                weather2 = new Weather("22", "24", Weather.DESZCZ, "50%", "990hPa");
                weather3 = new Weather("22", "23", Weather.BURZA, "70%", "995hPa");
                break;
            case 3:
                weather1 = new Weather("15", "20", Weather.ZACHMURZONE_NIEBO, "50%", "995hPa");
                weather2 = new Weather("23", "26", Weather.SLONCE, "50%", "1000hPa");
                weather3 = new Weather("16", "17", Weather.MZAWKA, "100%", "997hPa");
                break;
            case 4:
                weather1 = new Weather("-3", "-1", Weather.SNIEG, "50%", "1000hPa");
                weather2 = new Weather("-10", "-4", Weather.SNIEG, "30%", "990hPa");
                weather3 = new Weather("0", "4", Weather.GRAD, "10%", "995hPa");
                break;
            case 5:
                weather1 = new Weather("23", "27", Weather.DESZCZ, "65%", "1000hPa");
                weather2 = new Weather("19", "23", Weather.DESZCZ, "55%", "990hPa");
                weather3 = new Weather("22", "23", Weather.BURZA, "75%", "995hPa");
                break;
            case 6:
                weather1 = new Weather("15", "17", Weather.CZESCIOWE_ZACHMURZENIE, "30%", "990hPa");
                weather2 = new Weather("15", "20", Weather.ZACHMURZONE_NIEBO, "55%", "995hPa");
                weather3 = new Weather("14", "15", Weather.MGLA, "90%", "992hPa");
                break;
            case 7:
                weather1 = new Weather("15", "23", Weather.MGLA, "10%", "1000hPa");
                weather2 = new Weather("20", "22", Weather.DESZCZ, "50%", "990hPa");
                weather3 = new Weather("22", "24", Weather.SLONCE, "70%", "995hPa");
                break;
            default:
                weather1 = new Weather("15", "20", Weather.MGLA, "10%", "1000hPa");
                weather2 = new Weather("20", "22", Weather.DESZCZ, "50%", "990hPa");
                weather3 = new Weather("22", "24", Weather.SLONCE, "70%", "995hPa");

        }
        temp.set(weather1.getTemp() + "℃");
        weatherType.set(weather1.getWeatherType());
        humidity.set(weather1.getHumidity());
        pressure.set(weather1.getPressure());
        weatherTypeTomorrow.set(weather2.getWeatherType());
        tempTomorrow.set(weather2.getTemp() + "℃");
        maxTempTomorrow.set(weather2.getTempMax() + "℃");
        weatherTypeOvermorrow.set(weather3.getWeatherType());
        tempOvermorrow.set(weather3.getTemp() + "℃");
        maxTempOvermorrow.set(weather3.getTempMax() + "℃");
    }
}
