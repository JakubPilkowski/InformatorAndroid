package pl.android.informator.adapters.lines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.informator.R;

import java.util.List;

import pl.android.informator.models.CommunicationLine;

public class LinesAdapter extends ArrayAdapter {
    private LayoutInflater mInflater;

    public LinesAdapter(@NonNull Context context, List<CommunicationLine>lines) {
        super(context, R.layout.single_line_view);
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = mInflater.inflate(R.layout.calendar_day, parent, false);
        }
        return view;

    }
}
