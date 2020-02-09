package pl.android.informator.adapters.lines;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.informator.R;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.models.CommunicationLine;

public class LinesAdapter extends ArrayAdapter {
    private LayoutInflater mInflater;
    private List<CommunicationLine>lines = new ArrayList<>();
    public LinesAdapter(@NonNull Context context, List<CommunicationLine>lines) {
        super(context, R.layout.single_line_view);
        mInflater = LayoutInflater.from(context);
        this.lines=lines;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = mInflater.inflate(R.layout.single_line_view, parent, false);
        }
        TextView line = view.findViewById(R.id.single_line_number);
        TextView lineHolder = view.findViewById(R.id.single_line_event_holder);
        Log.d("itemy",String.valueOf(position));
        Log.d("itemy", String.valueOf(lines.get(position).getNumber()));
        line.setText(String.valueOf(lines.get(position).getNumber()));
        lineHolder.setText(String.valueOf(lines.get(position).getId()));
        return view;

    }
    @Override
    public int getCount() {
        return lines.size();
    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return lines.get(position);
    }
    @Override
    public int getPosition(Object item) {
        return lines.indexOf(item);
    }
}
