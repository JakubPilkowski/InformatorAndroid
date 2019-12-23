package com.example.informator.helpers;


import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("toolbarTextColor")
    public static void setTextColor(TextView view, int color) {
        String text = view.getText().toString();
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        builder.setSpan(new ForegroundColorSpan(color), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setText(builder);
    }
}
