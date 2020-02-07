package pl.android.informator.navigation;

import android.content.Intent;
import android.net.Uri;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.informator.R;

import pl.android.informator.models.Event;
import pl.android.informator.models.Notice;
import pl.android.informator.ui.events.EventsFragment;
import pl.android.informator.ui.events.event_details.EventDetailsFragment;
import pl.android.informator.ui.home.HomeFragment;
import pl.android.informator.ui.notice_board.NoticeBoardFragment;
import pl.android.informator.ui.notice_board.add_notice.AddNoticeFragment;
import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsFragment;
import pl.android.informator.ui.offers.OffersFragment;
import pl.android.informator.ui.offices.OfficesFragment;
import pl.android.informator.ui.offices.post_offices.PostOfficesFragment;
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

    public void showNoticeBoard() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(NoticeBoardFragment.TAG)
                .replace(R.id.main_container, NoticeBoardFragment.newInstance(),NoticeBoardFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showWeather() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(WeatherFragment.TAG)
                .replace(R.id.main_container, WeatherFragment.newInstance(),WeatherFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showEvents() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(EventsFragment.TAG)
                .replace(R.id.main_container,EventsFragment.newInstance(),EventsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showOffers() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(OffersFragment.TAG)
                .replace(R.id.main_container,OffersFragment.newInstance(),OffersFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void showTimetable() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(TimetableFragment.TAG)
                .replace(R.id.main_container, TimetableFragment.newInstance(),TimetableFragment.TAG)
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
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(AddNoticeFragment.TAG)
                .replace(R.id.main_container, AddNoticeFragment.newInstance(), AddNoticeFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showNoticeDetails(Notice notice) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(NoticeDetailsFragment.TAG)
                .replace(R.id.main_container, NoticeDetailsFragment.newInstance(notice), NoticeDetailsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
    public void openSite(String uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        activity.startActivity(intent);
    }

    public void showEvent(Event event) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(EventDetailsFragment.TAG)
                .replace(R.id.main_container, EventDetailsFragment.newInstance(event), EventDetailsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
