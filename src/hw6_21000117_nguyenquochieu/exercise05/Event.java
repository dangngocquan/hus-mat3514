package hw6_21000117_nguyenquochieu.exercise05;
import hw6_21000117_nguyenquochieu.exercise01.Entry;

public class Event implements Entry {
    private TimeController timeStamp;
    private String id;
    private String destination;

    public Event(TimeController timeStamp, String id, String destination) {
        this.timeStamp = timeStamp;
        this.id = id;
        this.destination = destination;
    }

    public TimeController getTimeStamp() {
        return timeStamp;
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }


    @Override
    public Object getKey() {
        return timeStamp;
    }

    @Override
    public Object getValue() {
        return this;
    }

    @Override
    public String toString() {
        return "Event: ID= " + id + " from Ha Noi to " + destination;
    }
}
