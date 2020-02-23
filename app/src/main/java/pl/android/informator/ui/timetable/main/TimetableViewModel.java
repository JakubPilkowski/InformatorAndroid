package pl.android.informator.ui.timetable.main;

import pl.android.informator.base.BaseViewModel;

public class TimetableViewModel extends BaseViewModel {


    public void init() {

    }

    public void onSetRouteClick() {
        getNavigator().showSetRouteFragment();
    }

    public void onLineDistributionClick() {
        getNavigator().showLineTimetables();
    }
    // TODO: Implement the ViewModel
}
