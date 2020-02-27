package pl.android.informator.adapters.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.informator.R;

import java.util.ArrayList;

import pl.android.informator.models.SearchResult;

public class SearchAdapter extends ArrayAdapter {
    private LayoutInflater mInflater;
    private ArrayList<SearchResult> lines;

    public SearchAdapter(@NonNull Context context, int resource, ArrayList<SearchResult>lines) {
        super(context, resource);
        mInflater = LayoutInflater.from(context);
        this.lines = lines;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null) {
            if (position == 0) {
                view = mInflater.inflate(R.layout.search_localization_item,parent,false);
            }
            else{
                view = mInflater.inflate(R.layout.search_default_item,parent,false);
                TextView title = view.findViewById(R.id.searched_bus_station);
                TextView availableLinesView = view.findViewById(R.id.searched_buses);

                title.setText(lines.get(position-1).getBusStation());
                StringBuilder allLinesText = new StringBuilder();
                ArrayList<String>allLines = lines.get(position-1).getLines();
                for (int i = 0; i <allLines.size() ; i++) {
                    if(i+1==lines.get(position-1).getLines().size()){
                        allLinesText.append(allLines.get(i));
                    }
                    else {
                        allLinesText.append(allLines.get(i));
                        allLinesText.append(", ");
                    }
                }
                availableLinesView.setText(allLinesText);

            }
        }
        return view;
    }

    @Override
    public int getCount() {
        return lines.size()+1;
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
