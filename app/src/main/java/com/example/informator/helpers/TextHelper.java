package com.example.informator.helpers;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class TextHelper {
    public static int getPixels(int unit, float size) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) TypedValue.applyDimension(unit, size, metrics);
    }
}
