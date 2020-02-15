package pl.android.informator.navigation;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.informator.R;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.models.BusStop;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.models.Event;
import pl.android.informator.models.Notice;
import pl.android.informator.models.Weather;
import pl.android.informator.ui.events.EventsFragment;
import pl.android.informator.ui.events.event_details.EventDetailsFragment;
import pl.android.informator.ui.home.HomeFragment;
import pl.android.informator.ui.notice_board.NoticeBoardFragment;
import pl.android.informator.ui.notice_board.add_notice.AddNoticeFragment;
import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsFragment;
import pl.android.informator.ui.offers.OffersFragment;
import pl.android.informator.ui.offices.OfficesFragment;
import pl.android.informator.ui.offices.post_offices.PostOfficesFragment;
import pl.android.informator.ui.timetable.line_timetables.LineTimetablesFragment;
import pl.android.informator.ui.timetable.line_timetables.line_details.LineDetailsFragment;
import pl.android.informator.ui.timetable.line_timetables.single_line.SingleLineFragment;
import pl.android.informator.ui.timetable.main.TimetableFragment;
import pl.android.informator.ui.weather.WeatherFragment;

public class Navigator {
    FragmentActivity activity;

    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
    }

    public void clearBackStack() {
        activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void clearFragment(String tag) {
        activity.getSupportFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void showNoticeBoard() {
        deleteUselessFragments(NoticeBoardFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(NoticeBoardFragment.TAG)
                .replace(R.id.main_container, NoticeBoardFragment.newInstance(), NoticeBoardFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void deleteUselessFragments(String tag) {
        Log.d("fragmenty", String.valueOf(activity.getSupportFragmentManager().getBackStackEntryCount()));
        for (int i = 0; i < activity.getSupportFragmentManager().getBackStackEntryCount(); i++) {
            FragmentManager.BackStackEntry backStackEntry = activity.getSupportFragmentManager().getBackStackEntryAt(i);
            String tmpTag = backStackEntry.getName();
            Log.d("fragmenty", tmpTag);
            if (!tmpTag.contains(tag) && !tmpTag.equals(HomeFragment.TAG)) {
                activity.getSupportFragmentManager().popBackStack(tmpTag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }
    }

    public boolean isAvailable(String tag) {
        for (int i = 0; i < activity.getSupportFragmentManager().getBackStackEntryCount(); i++) {
            FragmentManager.BackStackEntry backStackEntry = activity.getSupportFragmentManager().getBackStackEntryAt(i);
            String tmpTag = backStackEntry.getName();
            Log.d("fragmenty", tmpTag);
            if (tmpTag.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public void showWeather() {
        deleteUselessFragments(WeatherFragment.TAG);
//        if (!isAvailable(WeatherFragment.TAG)) {
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(WeatherFragment.TAG)
                    .replace(R.id.main_container, WeatherFragment.newInstance(), WeatherFragment.TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
//        else {
//            Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag(WeatherFragment.TAG);
//            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment,WeatherFragment.TAG)
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
//        }
//    }

    public void showEvents() {
        deleteUselessFragments(EventDetailsFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(EventsFragment.TAG)
                .replace(R.id.main_container, EventsFragment.newInstance(), EventsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showOffers() {
        deleteUselessFragments(OffersFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(OffersFragment.TAG)
                .replace(R.id.main_container, OffersFragment.newInstance(), OffersFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showTimetable() {
        deleteUselessFragments(TimetableFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(TimetableFragment.TAG)
                .replace(R.id.main_container, TimetableFragment.newInstance(), TimetableFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showOffices() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(OfficesFragment.TAG)
                .replace(R.id.main_container, OfficesFragment.newInstance(), OfficesFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showHome() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(HomeFragment.TAG)
                .replace(R.id.main_container, HomeFragment.newInstance(), HomeFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showPostOffices() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(PostOfficesFragment.TAG)
                .replace(R.id.main_container, PostOfficesFragment.newInstance(), PostOfficesFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void addNotice() {
        deleteUselessFragments(NoticeBoardFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(NoticeBoardFragment.TAG+AddNoticeFragment.TAG)
                .replace(R.id.main_container, AddNoticeFragment.newInstance(), NoticeBoardFragment.TAG+AddNoticeFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showNoticeDetails(Notice notice) {
        deleteUselessFragments(NoticeBoardFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(NoticeBoardFragment.TAG+NoticeDetailsFragment.TAG)
                .replace(R.id.main_container, NoticeDetailsFragment.newInstance(notice), NoticeBoardFragment.TAG+NoticeDetailsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void openSite(String uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        activity.startActivity(intent);
    }

    public void showEvent(Event event) {
        deleteUselessFragments(EventsFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(EventsFragment.TAG+EventDetailsFragment.TAG)
                .replace(R.id.main_container, EventDetailsFragment.newInstance(event), EventsFragment.TAG+EventDetailsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showLineTimetables() {
        deleteUselessFragments(TimetableFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(TimetableFragment.TAG+LineTimetablesFragment.TAG)
                .replace(R.id.main_container, LineTimetablesFragment.newInstance(), TimetableFragment.TAG+LineTimetablesFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showLine(CommunicationLine line) {
        deleteUselessFragments(TimetableFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(TimetableFragment.TAG+SingleLineFragment.TAG)
                .replace(R.id.main_container, SingleLineFragment.newInstance(line), TimetableFragment.TAG+SingleLineFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showMap(CommunicationLine line) {
    }

    public void showLineDetails(BusStop stop, CommunicationLine line) {
        deleteUselessFragments(TimetableFragment.TAG);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(TimetableFragment.TAG+LineDetailsFragment.TAG)
                .replace(R.id.main_container, LineDetailsFragment.newInstance(stop, line), TimetableFragment.TAG+LineDetailsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
