package pl.android.informator.ui.home;

import androidx.core.view.GravityCompat;
import androidx.databinding.ObservableInt;

import com.android.informator.R;
import com.android.informator.databinding.ActivityMainBinding;

import pl.android.informator.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public void init(){
    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getFragmentBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
