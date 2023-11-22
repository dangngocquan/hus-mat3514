package hw6_21000699_dangngocquan.exercise005.models;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {
    public String name;
    public LocalDateTime timeOccur;

    public Event(String name, LocalDateTime timeOccur) {
        this.name = name;
        this.timeOccur = timeOccur;
    }

    @Override
    public int compareTo(Event o) {
        if (timeOccur.isBefore(o.timeOccur)) return -1;
        if (timeOccur.isAfter(o.timeOccur)) return 1;
        return 0;
    }

    public String stringTimeOccur() {
        return timeOccur.getDayOfMonth() + "/"
                + timeOccur.getMonthValue() + "/"
                + timeOccur.getYear() + " "
                + timeOccur.getHour() + ":"
                + timeOccur.getMinute();
    }

    @Override
    public String toString() {
        return name + ". Occur time: "
                + timeOccur.getDayOfMonth() + "/"
                + timeOccur.getMonthValue() + "/"
                + timeOccur.getYear() + " "
                + timeOccur.getHour() + ":"
                + timeOccur.getMinute();
    }
}
