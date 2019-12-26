package com.example.informator.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;

import com.example.informator.R;

import static com.example.informator.helpers.DateHelper.getHourToBeginSun;

public class WeatherHelper {

    public static final String BURZA = "Burza";
    public static final String DESZCZ = "Opady deszczu";
    public static final String GRAD = "Grad";
    public static final String SLONCE = "Słoneczna pogoda";
    public static final String MZAWKA = "Mzawka";
    public static final String SNIEG = "Opady Śniegu";
    public static final String ZACHMURZONE_NIEBO = "Zachmurzone niebo";
    public static final String CZESCIOWE_ZACHMURZENIE = "Częściowe zachmurzenie";
    public static final String BEZCHMURNA_NOC = "Bezchmurna noc";
    public static final String MGLA = "Mgła";


    @RequiresApi(api = Build.VERSION_CODES.O)
    static Drawable getWeatherDrawable(Context context, String type){
        String date = DateHelper.getDate();
        int monthValue = Integer.parseInt(DateHelper.getMonth(date));
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= monthValue && monthValue <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
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
        int monthValue = Integer.parseInt(DateHelper.getMonth(date));
        if(type.equals(BURZA)) return context.getDrawable(R.drawable.burza);
        if(type.equals(DESZCZ)||type.equals(GRAD)||type.equals(MZAWKA)) return context.getDrawable(R.drawable.deszcz);
        if (Integer.parseInt(DateHelper.getHourToBeginSun(date)) <= monthValue && monthValue <= Integer.parseInt(DateHelper.getHourToEndSun(date)))
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
