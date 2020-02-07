package pl.android.informator.activities;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;

import com.android.informator.R;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.base.BaseViewModel;
import com.android.informator.databinding.ActivityMainBinding;
import pl.android.informator.helpers.TextHelper;

public class MainActivityViewModel extends BaseViewModel {
    public ObservableInt visibility = new ObservableInt();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<Drawable> background = new ObservableField<>();
    public ObservableFloat textSize = new ObservableFloat();
    public ObservableInt textColor = new ObservableInt();

    public void refreshToolbar() {
        BaseFragment fragment = ((MainActivity) getActivity()).getCurrentFragment();
        MainActivity activity = ((MainActivity) getActivity());
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
