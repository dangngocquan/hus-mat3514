package hw6_21000673_nguyenvandai.exercise5;

import java.time.LocalDateTime;

public class FlightEvent implements Comparable<FlightEvent> {
    private LocalDateTime timestamp;
    private String eventName;

    public FlightEvent(LocalDateTime timestamp, String eventName) {
        this.timestamp = timestamp;
        this.eventName = eventName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public int compareTo(FlightEvent other) {
        return this.timestamp.compareTo(other.getTimestamp());
    }
}