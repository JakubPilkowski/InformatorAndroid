package pl.android.informator.ui.home;

import android.graphics.drawable.Drawable;

import androidx.core.view.GravityCompat;
import androidx.databinding.ObservableField;

import pl.android.informator.base.BaseViewModel;

import com.android.informator.R;
import com.android.informator.databinding.ActivityMainBinding;

import java.util.Observable;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public ObservableField<Drawable>mainImage = new ObservableField<>();
    public void init(){
        mainImage.set(getActivity().getResources().getDrawable(R.drawable.informator_olsztyn_z_napisem));
    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
