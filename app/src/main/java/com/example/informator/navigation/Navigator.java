package com.example.informator.navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.informator.R;
import com.example.informator.databinding.OfficesFragmentBinding;
import com.example.informator.ui.home.HomeFragment;
import com.example.informator.ui.offices.OfficesFragment;

public class Navigator {
    FragmentActivity activity;

    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
    }

    public void clearBackStack() {
        activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void showNoticeBoard() {
//        activity.getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack()
//                .replace()
//                .setTransition()
//                .commit();
    }

    public void showWeather() {
//        activity.getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack()
//                .replace()
//                .setTransition()
//                .commit();
    }

    public void showEvents() {
//        activity.getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack()
//                .replace()
//                .setTransition()
//                .commit();
    }

    public void showOffers() {
//        activity.getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack()
//                .replace()
//                .setTransition()
//                .commit();
    }

    public void showTimetable() {
//        activity.getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack()
//                .replace()
//                .setTransition()
//                .commit();
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
}
