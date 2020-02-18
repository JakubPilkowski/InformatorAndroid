package pl.android.informator.helpers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
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
    private static final int MAX_HEIGHT = 256;
    private static final int MAX_WIDTH = 256;
    public static Bitmap decodeSampledBitmap(Context context, Uri selectedImage)
            throws IOException {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream imageStream = context.getContentResolver().openInputStream(selectedImage);
        BitmapFactory.decodeStream(imageStream, null, options);
        imageStream.close();

        options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT);

        options.inJustDecodeBounds = false;
        imageStream = context.getContentResolver().openInputStream(selectedImage);
        Bitmap img = BitmapFactory.decodeStream(imageStream, null, options);

        img = rotateImageIfRequired(context, img, selectedImage);
        return img;
    }
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;

            final float totalPixels = width * height;
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }
    public static Bitmap rotateImageIfRequired(Context context, Bitmap img, Uri selectedImage) {

        int rotation = getRotation(context, selectedImage);
        if (rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            return Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        }
        else{
            return img;
        }
    }

    private static int getRotation(Context context,Uri selectedImage) {

        int rotation = 0;
        ContentResolver content = context.getContentResolver();

        Cursor mediaCursor = content.query(selectedImage,
                new String[] { "orientation", "date_added" },
                null, null, "date_added desc");

        if (mediaCursor != null && mediaCursor.getCount() != 0) {
            while(mediaCursor.moveToNext()){
                rotation = mediaCursor.getInt(0);
            }
        }
        mediaCursor.close();
        return rotation;
    }
}
