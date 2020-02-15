package pl.android.informator.ui.weather;

import android.graphics.Bitmap;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseViewModel;
import com.android.informator.databinding.WeatherFragmentBinding;

import pl.android.informator.helpers.ImageHelper;
import pl.android.informator.helpers.WeatherHelper;
import pl.android.informator.models.Weather;

import java.util.Random;

public class WeatherViewModel extends BaseViewModel {


    public ObservableField<String> temp = new ObservableField<>();
    public ObservableField<Bitmap> weatherType = new ObservableField<>();
    public ObservableField<String> weatherTypeName = new ObservableField<>();
    public ObservableField<String> humidity = new ObservableField<>();
    public ObservableField<String> pressure = new ObservableField<>();
    public ObservableInt weatherTypeTomorrow = new ObservableInt();
    public ObservableField<String> tempTomorrow = new ObservableField<>();
    public ObservableField<String> maxTempTomorrow = new ObservableField<>();
    public ObservableInt weatherTypeOvermorrow = new ObservableInt();
    public ObservableField<String> tempOvermorrow = new ObservableField<>();
    public ObservableField<String> maxTempOvermorrow = new ObservableField<>();
    public Weather weather1;
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
        this.weather1 = weather1;
        temp.set(weather1.getTemp() + "℃");
        if(weather1.getWeatherType().equals(Weather.SLONCE) && WeatherHelper.getDayType().equals(WeatherHelper.NIGHT))
            weatherTypeName.set(Weather.BEZCHMURNA_NOC);
        else
            weatherTypeName.set(weather1.getWeatherType());
        humidity.set(weather1.getHumidity());
        pressure.set(weather1.getPressure());
        int drawableTomorrow = WeatherHelper.getWeatherDrawable(weather2.getWeatherType());
        weatherTypeTomorrow.set(drawableTomorrow);
        tempTomorrow.set(weather2.getTemp() + "℃");
        maxTempTomorrow.set(weather2.getTempMax() + "℃");
        int drawableOvermorrow = WeatherHelper.getWeatherDrawable(weather3.getWeatherType());
        weatherTypeOvermorrow.set(drawableOvermorrow);
        tempOvermorrow.set(weather3.getTemp() + "℃");
        maxTempOvermorrow.set(weather3.getTempMax() + "℃");
    }

    public void setMainImage() {
        View view = ((WeatherFragmentBinding)getBinding()).weatherMainImage;
        Bitmap bitmap =ImageHelper.getScaledBitmap(view,weather1);
        weatherType.set(bitmap);
    }
}
