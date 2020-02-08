package pl.android.informator.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import com.android.informator.R;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.navigation.Navigator;

public abstract class ArrayView<I> extends LinearLayout {
    public Context context;
    public List<I> items = new ArrayList<>();
    private Navigator navigator;

    public Navigator getNavigator() {
        return navigator;
    }

    public ArrayView(Context context) {
        super(context);
        initControl(context);
        this.context = context;
    }
    public void setItems(List<I> items){
        this.items.clear();
        this.items.addAll(items);
        setUpAdapter();
    }
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }
    @LayoutRes
    public abstract int getLayoutRes();

    public abstract void assignUiElements();

    public abstract void setUpAdapter();


    private void initControl(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(getLayoutRes(), this);
        assignUiElements();
    }
}
