package com.example.informator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.informator.R;
import com.example.informator.base.BaseActivity;
import com.example.informator.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void initActivity(ActivityMainBinding binding) {
        binding.setViewModel(viewModel);
//        viewModel.setProviders(this);

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
}
