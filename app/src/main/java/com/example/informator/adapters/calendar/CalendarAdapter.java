package com.example.informator.adapters.calendar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.informator.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarAdapter extends ArrayAdapter {
//    private static final String TAG = CalendarAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    private List<Date> monthlyDates;
    private Calendar currentDate;
    public CalendarAdapter(Context context, List<Date> monthlyDates, Calendar currentDate) {
        super(context, R.layout.calendar_day);
        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
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
        if(displayMonth == currentMonth && displayYear == currentYear){
            cell.setBackgroundColor(view.getContext().getColor(R.color.colorGrayBackgroundDay));
            cell.setTextColor(view.getContext().getColor(R.color.colorCalendarDayName));
        }else{
            view.setBackgroundColor(Color.parseColor("#cccccc"));
        }
        //Add day to calendar
        cell.setText(String.valueOf(dayValue));
        //Add events to the calendar
//        Calendar eventCalendar = Calendar.getInstance();
//        for(int i = 0; i < allEvents.size(); i++){
//            eventCalendar.setTime(allEvents.get(i).getDate());
//            if(dayValue == eventCalendar.get(Calendar.DAY_OF_MONTH) && displayMonth == eventCalendar.get(Calendar.MONTH) + 1
//                    && displayYear == eventCalendar.get(Calendar.YEAR)){
//                eventIndicator.setBackgroundColor(Color.parseColor("#FF4081"));
//            }
//        }
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
