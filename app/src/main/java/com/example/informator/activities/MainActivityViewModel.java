package com.example.informator.activities;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;

import com.example.informator.R;
import com.example.informator.base.BaseFragment;
import com.example.informator.base.BaseViewModel;
import com.example.informator.databinding.ActivityMainBinding;
import com.example.informator.helpers.TextHelper;

import java.util.Observable;

public class MainActivityViewModel extends BaseViewModel {
    public ObservableInt visibility = new ObservableInt();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<Drawable> background = new ObservableField<>();
    public ObservableFloat textSize = new ObservableFloat();
    public ObservableInt textColor = new ObservableInt();

    public void refreshToolbar() {
        BaseFragment fragment = ((MainActivity) getActivity()).getCurrentFragment();
        MainActivity activity = ((MainActivity) getActivity());
        Log.d("halo", "refreshToolbar: ");
        switch (fragment.getToolbarType()) {
            case 0:
                activity.setSupportActionBar(null);
                visibility.set(View.GONE);
                break;
            case 1:
                activity.setSupportActionBar(((ActivityMainBinding) activity.getBinding()).toolbar);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
                activity.getSupportActionBar().setHomeAsUpIndicator(fragment.getBlackBurger());
                title.set(fragment.getToolbarName());
                background.set(fragment.getContext().getDrawable(R.drawable.white_background));
                textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_SP, fragment.getToolbarFontSize()));
                textColor.set(ContextCompat.getColor(fragment.getContext(),R.color.colorBlack));
                visibility.set(View.VISIBLE);
                break;
            case 2:
                activity.setSupportActionBar(((ActivityMainBinding) activity.getBinding()).toolbar);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
                activity.getSupportActionBar().setHomeAsUpIndicator(fragment.getWhiteBurger());
                title.set(fragment.getToolbarName());
                background.set(fragment.getContext().getDrawable(R.drawable.black_background));
                textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_SP,fragment.getToolbarFontSize()));
                textColor.set(ContextCompat.getColor(fragment.getContext(),R.color.colorWhite));
                visibility.set(View.VISIBLE);
                break;
            case 3:
                break;
        }

    }
}
