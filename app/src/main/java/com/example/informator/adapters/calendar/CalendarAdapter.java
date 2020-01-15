package com.example.informator.adapters.calendar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.informator.R;
import com.example.informator.models.Event;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarAdapter extends ArrayAdapter {
    private LayoutInflater mInflater;
    private List<Date> monthlyDates;
    private Calendar currentDate;
    private List<Event>events;
    public CalendarAdapter(Context context, List<Date> monthlyDates, Calendar currentDate, List<Event>events) {
        super(context, R.layout.calendar_day);
        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
        this.events = events;
        mInflater = LayoutInflater.from(context);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Date mDate = monthlyDates.get(position);
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);
        int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        int displayYear = dateCal.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        int currentYear = currentDate.get(Calendar.YEAR);
        View view = convertView;
        if(view == null){
            view = mInflater.inflate(R.layout.calendar_day, parent, false);
        }
        TextView cell = view.findViewById(R.id.calendar_day_value);
        TextView id_holder = view.findViewById(R.id.event_id_holder);
        if(displayMonth == currentMonth && displayYear == currentYear){
            cell.setBackgroundColor(view.getContext().getColor(R.color.colorGrayBackgroundDay));
            cell.setTextColor(view.getContext().getColor(R.color.colorCalendarDayName));
        }else{
            cell.setBackgroundColor(view.getContext().getColor(R.color.colorBlackLight));
            cell.setTextColor(view.getContext().getColor(R.color.colorGray2));
        }
        cell.setText(String.valueOf(dayValue));
        Calendar eventCalendar = Calendar.getInstance();
        for(int i = 0; i <events.size(); i++){
            eventCalendar.setTime(events.get(i).getDate());
            if(dayValue == eventCalendar.get(Calendar.DAY_OF_MONTH) && displayMonth == currentMonth
                    && displayYear == eventCalendar.get(Calendar.YEAR)){
                cell.setBackgroundColor(view.getContext().getColor(R.color.colorWhite));
                cell.setTextColor(view.getContext().getColor(R.color.colorGray2));
                id_holder.setText(String.valueOf(events.get(i).getId()));
            }
        }
        return view;
    }
    @Override
    public int getCount() {
        return monthlyDates.size();
    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return monthlyDates.get(position);
    }
    @Override
    public int getPosition(Object item) {
        return monthlyDates.indexOf(item);
    }
}
