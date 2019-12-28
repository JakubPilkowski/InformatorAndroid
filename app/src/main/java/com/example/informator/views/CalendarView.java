package com.example.informator.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.informator.R;
import com.example.informator.adapters.calendar.CalendarAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class CalendarView extends LinearLayout {

    private static final int MAX_CALENDAR_COLUMN = 42;
    TextView btnPrev;
    TextView btnNext;
    TextView txtDisplayDate;
    GridView gridView;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy",Locale.GERMANY);
    Calendar calendar = Calendar.getInstance(Locale.GERMANY);
    CalendarAdapter mAdapter;
    Context context;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
        setUpCalendarAdapter();
        setPreviousButtonClickEvent();
        setNextButtonClickEvent();
        setGridCellClickEvent();
        this.context = context;
    }
    private void assignUiElements() {
        btnPrev = findViewById(R.id.calendar_prev_button);
        btnNext = findViewById(R.id.calendar_next_button);
        txtDisplayDate = findViewById(R.id.date_display_date);
        gridView = findViewById(R.id.calendar_grid);
    }

    private void initControl(Context context, AttributeSet attrs)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar_view, this);
        assignUiElements();
    }

    private void setGridCellClickEvent() {
        gridView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setNextButtonClickEvent() {
        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,1);
                setUpCalendarAdapter();
            }
        });
    }

    private void setPreviousButtonClickEvent() {
        btnPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,-1);
                setUpCalendarAdapter();
            }
        });
    }

    private void setUpCalendarAdapter() {
        List<Date> dayValueInCells = new ArrayList<Date>();
        Calendar mCal = (Calendar)calendar.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        while(dayValueInCells.size() < MAX_CALENDAR_COLUMN){
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        String sDate = sdf.format(calendar.getTime());
        txtDisplayDate.setText(sDate);
        mAdapter = new CalendarAdapter(context, dayValueInCells, calendar);
        gridView.setAdapter(mAdapter);

    }

}
