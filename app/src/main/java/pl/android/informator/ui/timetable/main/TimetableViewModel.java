package pl.android.informator.ui.timetable.main;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.android.informator.R;
import com.android.informator.databinding.TimetableFragmentBinding;

import java.math.BigInteger;
import java.sql.Time;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.BindingAdapter;
import pl.android.informator.helpers.ImageHelper;

public class TimetableViewModel extends BaseViewModel {

    public ObservableInt routeImage = new ObservableInt();
    public ObservableInt lineDistributionImage = new ObservableInt();

    public void init() {
        routeImage.set(R.drawable.wyznacz_trase);
        lineDistributionImage.set(R.drawable.rozklady_linii);
    }

    public void onSetRouteClick() {

    }

    public void onLineDistributionClick() {
        getNavigator().showLineTimetables();
    }
    // TODO: Implement the ViewModel
}
