package pl.android.informator.ui.events.event_details;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.android.informator.databinding.EventDetailsFragmentBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.DateHelper;
import pl.android.informator.models.Event;

public class EventDetailsViewModel extends BaseViewModel {
    private static final int VISIBLE = 1;
    private static final int GONE = 0;
    private static final int NOTHING = -1;

    public ObservableField<String>title = new ObservableField<>();
    public ObservableField<String>desc = new ObservableField<>();
    public ObservableField<String>imgUrl = new ObservableField<>();
    public ObservableField<String>day = new ObservableField<>();
    public ObservableField<String>monthAndYear = new ObservableField<>();
    public ObservableInt show = new ObservableInt();
    public ObservableInt size = new ObservableInt();
    public void init(Event event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String strDate = dateFormat.format(event.getDate());
        day.set(DateHelper.getDay(strDate));
        monthAndYear.set(DateHelper.getMonthAndYear(strDate));
        title.set(event.getTitle());
        desc.set(event.getDesc());
        imgUrl.set(event.getImgUrl());
        show.set(NOTHING);
        LinearLayout offersDetails = ((EventDetailsFragmentBinding) getBinding()).eventDetailsDesc;
        offersDetails.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        int size = offersDetails.getMeasuredHeight();
        setSize(size);
        offersDetails.getLayoutParams().height = 0;
        offersDetails.requestLayout();
    }

    private void setSize(int size) {
        this.size.set(size);
    }

    public void onClick(){
        if(show.get()!=VISIBLE)
            show.set(VISIBLE);
        else
            show.set(GONE);
    }
    // TODO: Implement the ViewModel
}
