package pl.android.informator.models;

import java.util.List;

public class CommunicationLine {
    private int id;
    private int number;
    private String from;
    private String to;
    private List<BusStop> busStops;

    public CommunicationLine(int id, int number, String from, String to, List<BusStop> busStops) {
        this.id = id;
        this.number = number;
        this.from = from;
        this.to = to;
        this.busStops = busStops;
    }

    public int getId() {
        return id;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public int getNumber() {
        return number;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
