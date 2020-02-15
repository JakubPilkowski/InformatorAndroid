package pl.android.informator.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;

import pl.android.informator.models.Weather;

public class ImageHelper {
    public static Bitmap getScaledBitmap(View view, Weather weather){
        int drawableID = WeatherHelper.getWeatherToolbarBackground(weather.getWeatherType());
        Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), drawableID);
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        int w = view.getMeasuredWidth();
        int h = view.getMeasuredHeight();
        return Bitmap.createScaledBitmap(bitmap,w,h,false);
    }

    public static Bitmap getScaledBitmap(View view, int drawableID){
        Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), drawableID);
        int w;
        int h;
        view.measure(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        w = view.getMeasuredWidth();
        h = view.getMeasuredHeight();
        return Bitmap.createScaledBitmap(bitmap,w,h,false);
    }

}
