package com.example.informator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.informator.R;
import com.example.informator.base.BaseActivity;
import com.example.informator.base.BaseFragment;
import com.example.informator.databinding.ActivityMainBinding;
import com.example.informator.interfaces.Providers;
import com.example.informator.navigation.Navigator;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements NavigationView.OnNavigationItemSelectedListener, Providers {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void initActivity(ActivityMainBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        navigator.showHome();
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected Class<MainActivityViewModel> getViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    public int getIdFragmentContainer() {
        return R.id.main_container;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_view_menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_timetable:
                navigator.showTimetable();
                break;
            case R.id.menu_weather:
                navigator.showWeather();
                break;
            case R.id.menu_events:
                navigator.showEvents();
                break;
            case R.id.menu_offers:
                navigator.showOffers();
                break;
            case R.id.menu_notice_board:
                navigator.showNoticeBoard();
                break;
            case R.id.menu_offices:
                navigator.showOffices();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Navigator getNavigator() {
        return navigator;
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getFragmentBinding() {
        BaseFragment fragment = (BaseFragment) getCurrentFragment();
        return fragment.binding;
    }
}
