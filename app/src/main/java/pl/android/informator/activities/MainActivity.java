package pl.android.informator.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.informator.R;
import com.android.informator.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import pl.android.informator.base.BaseActivity;
import pl.android.informator.base.BaseFragment;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;
import pl.android.informator.ui.notice_board.add_notice.AddNoticeFragment;
import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements NavigationView.OnNavigationItemSelectedListener, Providers {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public static final int RESULT_LOAD_IMAGE = 1001;
    public static final int REQUEST_CALL = 1002;
    public static final int REQUEST_SMS = 1003;
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
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.navigation_view_menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        drawerLayout.closeDrawer(GravityCompat.START);
        refreshToolbar();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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
//            case R.id.menu_offices:
//                navigator.showOffices();
//                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        drawerLayout.openDrawer(GravityCompat.START);
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
    public ViewDataBinding getActivityOrFragmentBinding() {
        BaseFragment fragment = getCurrentFragment();
        return fragment.binding;
    }

    @Override
    public BaseFragment getFragment() {
        return getCurrentFragment();
    }

    public void refreshToolbar() {
        viewModel.refreshToolbar();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RESULT_LOAD_IMAGE) {
            Log.d("viewpager","pobrane zdjecie");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        }
        if(requestCode == REQUEST_CALL){
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED){
                ((NoticeDetailsFragment)getCurrentFragment()).viewModel.onPhoneClick();
            }
        }
        if(requestCode == REQUEST_SMS){
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED){
                ((NoticeDetailsFragment)getCurrentFragment()).viewModel.onMessageClick();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            if(data!=null){
                ((AddNoticeFragment)getCurrentFragment()).viewModel.addPhoto(data.getData());
            }
        }
    }
}
