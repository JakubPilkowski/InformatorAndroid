package pl.android.informator.ui.home;

import androidx.core.view.GravityCompat;
import androidx.databinding.ObservableInt;

import com.android.informator.R;
import com.android.informator.databinding.ActivityMainBinding;

import pl.android.informator.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public ObservableInt mainImage = new ObservableInt();
    public void init(){
        mainImage.set(R.drawable.informator_olsztyn_z_napisem);

    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getFragmentBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
