package pl.android.informator.models;

import android.graphics.Bitmap;
import android.net.Uri;

public class Image {
    private Bitmap bitmap;
    private Uri uri;

    public Image(Bitmap bitmap, Uri uri) {
        this.bitmap = bitmap;
        this.uri = uri;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Uri getUri() {
        return uri;
    }
}
