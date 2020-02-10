package pl.android.informator.models;

import java.util.Date;
import java.util.List;

public class BusStop {
    private String name;
    private int timeFromStart;
    private List<Date>workingHours;
    private List<Date>freeFromWorkingHours;
    private List<Date>saturdaysHours;
    private List<Date>sundaysAndBreaksHours;

    public BusStop(String name, int timeFromStart, List<Date> workingHours, List<Date> freeFromWorkingHours, List<Date> saturdaysHours, List<Date> sundaysAndBreaksHours) {
        this.name = name;
        this.timeFromStart = timeFromStart;
        this.workingHours = workingHours;
        this.freeFromWorkingHours = freeFromWorkingHours;
        this.saturdaysHours = saturdaysHours;
        this.sundaysAndBreaksHours = sundaysAndBreaksHours;
    }

    public List<Date> getWorkingHours() {
        return workingHours;
    }

    public List<Date> getFreeFromWorkingHours() {
        return freeFromWorkingHours;
    }

    public List<Date> getSaturdaysHours() {
        return saturdaysHours;
    }

    public List<Date> getSundaysAndBreaksHours() {
        return sundaysAndBreaksHours;
    }

    public String getName() {
        return name;
    }

    public int getTimeFromStart() {
        return timeFromStart;
    }
}
