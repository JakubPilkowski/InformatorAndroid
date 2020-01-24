package pl.android.informator.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.informator.R;
import pl.android.informator.adapters.calendar.CalendarAdapter;
import pl.android.informator.helpers.DateHelper;
import pl.android.informator.models.Event;
import pl.android.informator.navigation.Navigator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarView extends LinearLayout {

    TextView btnPrev;
    TextView btnNext;
    TextView txtDisplayDate;
    GridView gridView;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH);
    Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
    CalendarAdapter mAdapter;
    Context context;
    Navigator navigator;
    List<Event>events = new ArrayList<>();
    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
        this.context = context;
        setPreviousButtonClickEvent();
        setNextButtonClickEvent();
        setGridCellClickEvent();
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setEvents(List<Event> events) {
        this.events.clear();
        this.events.addAll(events);
        setUpCalendarAdapter();
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RelativeLayout linearLayout = (RelativeLayout) view;
                TextView textView = linearLayout.findViewById(R.id.event_id_holder);
                if(!textView.getText().toString().isEmpty()){
                    for (Event event :events) {
                        if (event.getId()==Integer.parseInt(textView.getText().toString())){
                            navigator.showEvent(event);
                        }

                    }
                }
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
        List<Date> dayValueInCells = new ArrayList<>();
        Calendar mCal = (Calendar)calendar.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK)-1;
        if(firstDayOfTheMonth==0)
            firstDayOfTheMonth=7;
        firstDayOfTheMonth-=1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        int MAX_CALENDAR_COLUMN = 42;
        while(dayValueInCells.size() < MAX_CALENDAR_COLUMN){
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
            if(mCal.get(Calendar.MONTH)==calendar.get(Calendar.MONTH) && mCal.get(Calendar.DAY_OF_MONTH)==calendar.getActualMaximum(Calendar.DATE) && dayValueInCells.size()<=34){
                MAX_CALENDAR_COLUMN = 35;
            }
        }
        String sDate = sdf.format(calendar.getTime());
        txtDisplayDate.setText(DateHelper.getPolishFormatDate(sDate));
        mAdapter = new CalendarAdapter(context, dayValueInCells, calendar, events);
        gridView.setAdapter(mAdapter);

    }

}
