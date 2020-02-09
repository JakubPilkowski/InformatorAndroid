package pl.android.informator.models;

public class BusStop {
    private String name;
    private int timeFromStart;

    public BusStop(String name, int timeFromStart) {
        this.name = name;
        this.timeFromStart = timeFromStart;
    }

    public String getName() {
        return name;
    }

    public int getTimeFromStart() {
        return timeFromStart;
    }
}
