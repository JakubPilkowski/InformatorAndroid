package pl.android.informator.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SearchResult {

    private String busStation;
    private ArrayList<String>lines;

    public SearchResult(String busStation, ArrayList<String> lines) {
        this.busStation = busStation;
        this.lines = lines;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public String getBusStation() {
        return busStation;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getBusStation();
    }
}
