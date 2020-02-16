package pl.android.informator.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import pl.android.informator.models.Weather;

public class ImageHelper {
    public static Bitmap getScaledBitmap(View view, Weather weather){
        int drawableID = WeatherHelper.getWeatherToolbarBackground(weather.getWeatherType());
        Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), drawableID);
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        int w = view.getMeasuredWidth();
        int h = view.getMeasuredHeight();
        Bitmap output = Bitmap.createScaledBitmap(bitmap,w,h,false);
        bitmap.recycle();
        return output;
    }

    public static Bitmap getScaledBitmap(ImageView view, int drawableID){
        Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), drawableID);
        int w;
        int h;
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        Log.d("view", String.valueOf(view.getMeasuredWidth()));
        Log.d("view", String.valueOf(view.getMeasuredHeight()));
        Log.d("view", String.valueOf(view.getWidth()));
        Log.d("view", String.valueOf(view.getHeight()));
        Log.d("view", String.valueOf(view.getLayoutParams().width));
        Log.d("view", String.valueOf(view.getLayoutParams().height));
        w = view.getWidth();
        h = view.getHeight();
        return Bitmap.createScaledBitmap(bitmap,w,h,false);
    }

}
