package pl.android.informator.ui.home;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.core.view.GravityCompat;
import androidx.databinding.ObservableField;

import com.android.informator.R;
import com.android.informator.databinding.ActivityMainBinding;
import com.android.informator.databinding.HomeFragmentBinding;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.ImageHelper;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public ObservableField<Bitmap>mainImage = new ObservableField<>();
    public void init(){
        ImageView view = ((HomeFragmentBinding)getBinding()).mainImage;
//        mainImage.set(ImageHelper.getScaledBitmap(view,R.drawable.informator_olsztyn_z_napisem));

    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getFragmentBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
