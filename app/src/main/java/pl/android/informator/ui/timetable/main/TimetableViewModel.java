package pl.android.informator.ui.timetable.main;

import android.graphics.drawable.Drawable;

import androidx.databinding.ObservableField;

import com.android.informator.R;

import pl.android.informator.base.BaseViewModel;

public class TimetableViewModel extends BaseViewModel {

    public ObservableField<Drawable>routeImage = new ObservableField<>();
    public ObservableField<Drawable>lineDistributionImage = new ObservableField<>();
    public void init() {
        routeImage.set(getActivity().getResources().getDrawable(R.drawable.wyznacz_trase));
        lineDistributionImage.set(getActivity().getResources().getDrawable(R.drawable.rozklady_linii));
    }
    public void onSetRouteClick(){

    }
    public void onLineDistributionClick(){
        getNavigator().showLineTimetables();
    }
    // TODO: Implement the ViewModel
}
