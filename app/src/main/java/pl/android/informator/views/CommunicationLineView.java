package pl.android.informator.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.informator.R;

import pl.android.informator.adapters.lines.LinesAdapter;
import pl.android.informator.models.CommunicationLine;

public class CommunicationLineView extends ArrayView<CommunicationLine> {
    GridView linesGrid;
    ImageView iconImageView;
    TextView titleTextView;
    String title;
    int icon;

    public CommunicationLineView(Context context, AttributeSet attr) {
        super(context,attr);
        setGridCellClickEvent();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.lines_view;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public void assignUiElements() {
        linesGrid = findViewById(R.id.lines_grid);
        iconImageView = findViewById(R.id.communication_line_icon);
        titleTextView = findViewById(R.id.communication_line_text);
    }

    @Override
    public void setUpAdapter() {
        Log.d("itemy",String.valueOf(items));
        LinesAdapter mAdapter = new LinesAdapter(context,items);
        iconImageView.setImageResource(icon);
        titleTextView.setText(title);
        linesGrid.setAdapter(mAdapter);
    }


    private void setGridCellClickEvent() {
        linesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RelativeLayout linearLayout = (RelativeLayout) view;
                TextView textView = linearLayout.findViewById(R.id.single_line_event_holder);
                if(!textView.getText().toString().isEmpty()){
                    for (CommunicationLine line : items) {
                        if (line.getId()==Integer.parseInt(textView.getText().toString())){
                            getNavigator().showLine(line);
                        }
                    }
                }
            }
        });
    }



}
