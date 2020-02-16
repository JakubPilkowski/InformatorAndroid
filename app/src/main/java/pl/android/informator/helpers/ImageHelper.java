package pl.android.informator.helpers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    public static Bitmap scaleBitmap(Bitmap src, int dstMaxDimension) {

        int bitmapWidth = src.getWidth();
        int bitmapHeight = src.getHeight();
        int dstWidth;
        int dstHeight;
        float bitmapAspectRatio;

        if (bitmapWidth > bitmapHeight) {
            bitmapAspectRatio = (float) bitmapWidth / bitmapHeight;

            dstHeight = (int) (dstMaxDimension / bitmapAspectRatio);
            dstWidth = dstMaxDimension;
        } else {
            bitmapAspectRatio = (float) bitmapHeight / bitmapWidth;

            dstHeight = dstMaxDimension;
            dstWidth = (int) (dstMaxDimension / bitmapAspectRatio);
        }
        return Bitmap.createScaledBitmap(src, dstWidth, dstHeight, true);
    }

    public static Uri compressBitmap(ContentResolver contentResolver, Uri imageUri, int quality, int dstMaxDimension) {
        InputStream inputStream = null;
        try {
            inputStream = contentResolver.openInputStream(imageUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        File file;

        try {
            file = File.createTempFile("tempUploadPhoto", "jpg");
            OutputStream os = new BufferedOutputStream(new FileOutputStream(file));

            bitmap = scaleBitmap(bitmap, dstMaxDimension);

            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, os);
            os.close();
            bitmap.recycle();
            return Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
