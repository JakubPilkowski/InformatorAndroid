package pl.android.informator.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.informator.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pl.android.informator.adapters.calendar.CalendarAdapter;
import pl.android.informator.helpers.DateHelper;
import pl.android.informator.models.CommunicationLine;
import pl.android.informator.models.Event;
import pl.android.informator.navigation.Navigator;

public class CommunicationLineView extends LinearLayout {
    GridView linesGrid;
    ImageView iconImageView;
    TextView titleTextView;
    String title;
    String icon;
    Context context;
    Navigator navigator;
    List<CommunicationLine> lines = new ArrayList<>();
    public CommunicationLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
        this.context = context;
        setGridCellClickEvent();
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setLines(List<CommunicationLine> events) {
        this.lines.clear();
        this.lines.addAll(events);
        setUpCalendarAdapter();
    }

    private void assignUiElements() {

    }

    private void initControl(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lines_view, this);
        assignUiElements();
    }

    private void setGridCellClickEvent() {
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                RelativeLayout linearLayout = (RelativeLayout) view;
//                TextView textView = linearLayout.findViewById(R.id.event_id_holder);
//                if(!textView.getText().toString().isEmpty()){
//                    for (Event event : lines) {
//                        if (event.getId()==Integer.parseInt(textView.getText().toString())){
//                            navigator.showEvent(event);
//                        }
//
//                    }
//                }
//            }
//        });
    }


    private void setUpCalendarAdapter() {
//        gridView.setAdapter(mAdapter);
    }

}
