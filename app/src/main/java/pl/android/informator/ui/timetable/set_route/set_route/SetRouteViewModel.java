package pl.android.informator.ui.timetable.set_route.set_route;

import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.SearchView;

import com.android.informator.R;
import com.android.informator.databinding.SetRouteFragmentBinding;

import pl.android.informator.base.BaseViewModel;

public class SetRouteViewModel extends BaseViewModel {

    public void init() {
        final SearchView searchView1 = ((SetRouteFragmentBinding) getBinding()).searchView1;
        final SearchView searchView2 = ((SetRouteFragmentBinding) getBinding()).searchView2;

        searchView1.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    searchView1.setBackground(searchView1.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                else searchView1.setBackgroundResource(R.color.colorBlackLight);
            }
        });
        searchView2.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    searchView2.setBackground(searchView2.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                else searchView2.setBackgroundResource(R.color.colorBlackLight);
            }
        });
    }

    public void onNextClick() {

    }

    public void onChangeDestClick() {

    }

    public void onDepartureTimeClick() {

    }
}
