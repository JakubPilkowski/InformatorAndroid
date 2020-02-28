package pl.android.informator.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

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
import pl.android.informator.helpers.AlertDialogManager;
import pl.android.informator.helpers.ProgressDialogManager;
import pl.android.informator.helpers.TextHelper;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.navigation.Navigator;
import pl.android.informator.ui.notice_board.add_notice.AddNoticeFragment;
import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsFragment;
import pl.android.informator.ui.timetable.line_timetables.maps.MapFragment;
import pl.android.informator.ui.timetable.set_route.set_route.SetRouteFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements NavigationView.OnNavigationItemSelectedListener, Providers {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public static final int RESULT_LOAD_IMAGE = 1001;
    public static final int REQUEST_CALL = 1002;
    public static final int REQUEST_SMS = 1003;
    public static final int RESULT_ACCESS_FINE_LOCATION = 1004;
    private static MainActivity INSTANCE;
    private Menu menu;
    @Override
    protected void initActivity(ActivityMainBinding binding) {
        INSTANCE = this;
        AlertDialogManager.init(this,this);
        ProgressDialogManager.init(this);
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        navigator.showHome();
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        setKeyboardVisibilityListener();
    }
    public static MainActivity getINSTANCE(){
        return INSTANCE;
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
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem menuItem= menu.getItem(0);
        menuItem.setVisible(false);
        menuItem.setEnabled(false);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.action_reverse):
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ProgressDialogManager.get().dismiss();
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
        //hide keyboard
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


    private void setKeyboardVisibilityListener() {
        final View parentView = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            private boolean alreadyOpen;
            private final int defaultKeyboardHeightDP = 100;
            private final int EstimatedKeyboardDP = defaultKeyboardHeightDP + (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 48 : 0);
            private final Rect rect = new Rect();

            @Override
            public void onGlobalLayout() {
                int estimatedKeyboardHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, EstimatedKeyboardDP, parentView.getResources().getDisplayMetrics());
                parentView.getWindowVisibleDisplayFrame(rect);
                int heightDiff = parentView.getRootView().getHeight() - (rect.bottom - rect.top);
                boolean isShown = heightDiff >= estimatedKeyboardHeight;

                if (isShown == alreadyOpen) {
                    Log.i("Keyboard state", "Ignoring global layout change...");
                    return;
                }
                alreadyOpen = isShown;
                setKeyBoardEvent(isShown);
            }
        });
    }

    private void setKeyBoardEvent(boolean isShown) {
        if(getCurrentFragment() instanceof SetRouteFragment){
            SetRouteFragment fragment = (SetRouteFragment) getCurrentFragment();
            Log.d("halo", "setKeyBoardEvent: ");
            if(isShown){
//                fragment.viewModel.doneButton.setVisibility(View.GONE);
                fragment.viewModel.nextButton.setVisibility(View.GONE);
                fragment.viewModel.state = fragment.viewModel.STATE_SEARCHING;
                if(fragment.viewModel.search1.hasFocus()){
                    viewModel.title.set(getResources().getString(R.string.start_location));
                    viewModel.textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_DIP,16f));
                    fragment.viewModel.search2.setVisibility(View.GONE);
                    fragment.viewModel.recyclerView.setVisibility(View.VISIBLE);
                }
                if(fragment.viewModel.search2.hasFocus()){
                    viewModel.title.set(getResources().getString(R.string.end_location));
                    viewModel.textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_DIP,16f));
                    fragment.viewModel.search1.setVisibility(View.GONE);
                    fragment.viewModel.recyclerView.setVisibility(View.VISIBLE);
                }
            }
            //                    fragment.viewModel.doneButton.setVisibility(View.VISIBLE);

        }
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
        if(requestCode == RESULT_ACCESS_FINE_LOCATION){
            if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
                ((MapFragment)getCurrentFragment()).viewModel.initMap();
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
