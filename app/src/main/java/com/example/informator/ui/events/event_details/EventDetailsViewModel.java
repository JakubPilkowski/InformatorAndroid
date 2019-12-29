package com.example.informator.ui.events.event_details;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.example.informator.base.BaseViewModel;
import com.example.informator.helpers.DateHelper;
import com.example.informator.models.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void init(Event event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(event.getDate());
        day.set(DateHelper.getDay(strDate));
        monthAndYear.set(DateHelper.getMonthAndYear(strDate));
        title.set(event.getTitle());
        desc.set(event.getDesc());
        imgUrl.set(event.getImgUrl());
        show.set(NOTHING);
    }

    public void onClick(){
        if(show.get()!=VISIBLE)
            show.set(VISIBLE);
        else
            show.set(GONE);
    }
    // TODO: Implement the ViewModel
}
