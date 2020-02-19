package pl.android.informator.helpers;

import com.android.informator.R;

import static pl.android.informator.models.Weather.BURZA;
import static pl.android.informator.models.Weather.CZESCIOWE_ZACHMURZENIE;
import static pl.android.informator.models.Weather.DESZCZ;
import static pl.android.informator.models.Weather.GRAD;
import static pl.android.informator.models.Weather.MGLA;
import static pl.android.informator.models.Weather.MZAWKA;
import static pl.android.informator.models.Weather.SLONCE;
import static pl.android.informator.models.Weather.SNIEG;
import static pl.android.informator.models.Weather.ZACHMURZONE_NIEBO;

public class WeatherHelper {

    public static final String NIGHT = "Night";

    public static String getDayType(){
        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
            return "Day";
        else
            return "Night";
    }

    public static int getWeatherDrawable(String type){
        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
        {
            switch (type){
                case BURZA:
                    return R.drawable.ic_burzaislonce;
                case DESZCZ:
                    return R.drawable.ic_deszczislonce;
                case GRAD:
                    return R.drawable.ic_grad;
                case SLONCE:
                    return R.drawable.ic_slonce;
                case MZAWKA:
                    return R.drawable.ic_mzawka;
                case SNIEG:
                    return R.drawable.ic_sniegislonce;
                case ZACHMURZONE_NIEBO:
                case CZESCIOWE_ZACHMURZENIE:
                    return R.drawable.ic_chmuryislonce;
                case MGLA:
                    return R.drawable.ic_mgla;
            }
        }
        else {
            switch (type){
                case BURZA:
                    return R.drawable.ic_burzaiksiezyc;
                case DESZCZ:
                    return R.drawable.ic_deszcziksiezyc;
                case GRAD:
                    return R.drawable.ic_grad;
                case SLONCE:
                    return R.drawable.ic_ksiezyc;
                case MZAWKA:
                    return R.drawable.ic_mzawka;
                case SNIEG:
                    return R.drawable.ic_sniegiksiezyc;
                case ZACHMURZONE_NIEBO:
                case CZESCIOWE_ZACHMURZENIE:
                    return R.drawable.ic_chmuryiksiezyc;
                case MGLA:
                    return R.drawable.ic_mgla;
            }
        }
        return 0;
    }

    public static int getWeatherToolbarBackground(String type){

        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if(type.equals(BURZA)) return R.drawable.burza;
        if(type.equals(DESZCZ)||type.equals(GRAD)||type.equals(MZAWKA)) return R.drawable.deszcz;
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
        {
            switch (type){
                case SLONCE:
                    return R.drawable.sloneczna_pogoda;
                case SNIEG:
                    return R.drawable.opady_sniegu;
                case ZACHMURZONE_NIEBO:
                    return R.drawable.zachmurzone_niebo;
                case CZESCIOWE_ZACHMURZENIE:
                    return R.drawable.czesciowe_zachmurzenie_2;
                case MGLA:
                    return R.drawable.mgla;
            }
        }
        else {
            switch (type){
                case SLONCE:
                    return R.drawable.bezchmurna_noc;
                case SNIEG:
                    return R.drawable.opady_sniegu_2;
                case ZACHMURZONE_NIEBO:
                    return R.drawable.zachmurzone_niebo_2;
                case CZESCIOWE_ZACHMURZENIE:
                    return R.drawable.czesciowe_zachmurzenie;
                case MGLA:
                    return R.drawable.mgla_2;
            }
        }
        return 0;
    }
}
