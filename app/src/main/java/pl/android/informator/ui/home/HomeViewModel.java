package pl.android.informator.ui.home;

import androidx.core.view.GravityCompat;

import pl.android.informator.base.BaseViewModel;
import com.android.informator.databinding.ActivityMainBinding;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public void init(){

    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
