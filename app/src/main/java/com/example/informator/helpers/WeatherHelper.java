package com.example.informator.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.informator.R;

import static com.example.informator.models.Weather.BURZA;
import static com.example.informator.models.Weather.CZESCIOWE_ZACHMURZENIE;
import static com.example.informator.models.Weather.DESZCZ;
import static com.example.informator.models.Weather.GRAD;
import static com.example.informator.models.Weather.MGLA;
import static com.example.informator.models.Weather.MZAWKA;
import static com.example.informator.models.Weather.SLONCE;
import static com.example.informator.models.Weather.SNIEG;
import static com.example.informator.models.Weather.ZACHMURZONE_NIEBO;

public class WeatherHelper {

    public static final String DAY ="Day";
    public static final String NIGHT = "Night";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getDayType(){
        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
            return "Day";
        else
            return "Night";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static Drawable getWeatherDrawable(Context context, String type){
        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
        {
            switch (type){
                case BURZA:
                    return context.getDrawable(R.drawable.ic_burzaislonce);
                case DESZCZ:
                    return context.getDrawable(R.drawable.ic_deszczislonce);
                case GRAD:
                    return context.getDrawable(R.drawable.ic_grad);
                case SLONCE:
                    return context.getDrawable(R.drawable.ic_slonce);
                case MZAWKA:
                    return context.getDrawable(R.drawable.ic_mzawka);
                case SNIEG:
                    return context.getDrawable(R.drawable.ic_sniegislonce);
                case ZACHMURZONE_NIEBO:
                case CZESCIOWE_ZACHMURZENIE:
                    return context.getDrawable(R.drawable.ic_chmuryislonce);
                case MGLA:
                    return context.getDrawable(R.drawable.ic_mgla);
            }
        }
        else {
            switch (type){
                case BURZA:
                    return context.getDrawable(R.drawable.ic_burzaiksiezyc);
                case DESZCZ:
                    return context.getDrawable(R.drawable.ic_deszcziksiezyc);
                case GRAD:
                    return context.getDrawable(R.drawable.ic_grad);
                case SLONCE:
                    return context.getDrawable(R.drawable.ic_ksiezyc);
                case MZAWKA:
                    return context.getDrawable(R.drawable.ic_mzawka);
                case SNIEG:
                    return context.getDrawable(R.drawable.ic_sniegiksiezyc);
                case ZACHMURZONE_NIEBO:
                case CZESCIOWE_ZACHMURZENIE:
                    return context.getDrawable(R.drawable.ic_chmuryiksiezyc);
                case MGLA:
                    return context.getDrawable(R.drawable.ic_mgla);
            }
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Drawable getWeatherToolbarBackground(Context context, String type){

        String date = DateHelper.getDate();
        int actualHour = Integer.parseInt(DateHelper.getHour(date));
        if(type.equals(BURZA)) return context.getDrawable(R.drawable.burza);
        if(type.equals(DESZCZ)||type.equals(GRAD)||type.equals(MZAWKA)) return context.getDrawable(R.drawable.deszcz);
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= actualHour && actualHour <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
        {
            switch (type){
                case SLONCE:
                    return context.getDrawable(R.drawable.sloneczna_pogoda);
                case SNIEG:
                    return context.getDrawable(R.drawable.opady_sniegu);
                case ZACHMURZONE_NIEBO:
                    return context.getDrawable(R.drawable.zachmurzone_niebo);
                case CZESCIOWE_ZACHMURZENIE:
                    return context.getDrawable(R.drawable.czesciowe_zachmurzenie_2);
                case MGLA:
                    return context.getDrawable(R.drawable.mgla);
            }
        }
        else {
            switch (type){
                case SLONCE:
                    return context.getDrawable(R.drawable.bezchmurna_noc);
                case SNIEG:
                    return context.getDrawable(R.drawable.opady_sniegu_2);
                case ZACHMURZONE_NIEBO:
                    return context.getDrawable(R.drawable.zachmurzone_niebo_2);
                case CZESCIOWE_ZACHMURZENIE:
                    return context.getDrawable(R.drawable.czesciowe_zachmurzenie);
                case MGLA:
                    return context.getDrawable(R.drawable.mgla_2);
            }
        }
        return null;
    }
}