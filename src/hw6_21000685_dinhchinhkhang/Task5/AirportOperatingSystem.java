package hw6_21000685_dinhchinhkhang.Task5;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.Task1.SortedArrayPrimaryQueue;

public class AirportOperatingSystem {
    public static class FlightEvent implements Comparable<FlightEvent> {
        private double timeStamp;
        private String eventType;

        public FlightEvent(double timeStamp, String eventType) {
            this.timeStamp = timeStamp;
            this.eventType = eventType;
        }
        public double getTimeStamp() {
            return timeStamp;
        }
       public String getEventType() {
           return eventType;
       }

        @Override
        public int compareTo(FlightEvent other) {
            return Double.compare(this.timeStamp, other.timeStamp);
        }
    }

    public static void main(String[] args) {
        SortedArrayPrimaryQueue<Double, FlightEvent> eventManagementQueue = new SortedArrayPrimaryQueue<>();

        //Add event to the system
        eventManagementQueue.insert(2.0, new FlightEvent(2.0, "Takeoff"));
        eventManagementQueue.insert(1.0, new FlightEvent(1.0, "Landing"));
        eventManagementQueue.insert(3.0, new FlightEvent(3.0, "Takeoff"));
        //processing events
        while(!eventManagementQueue.isEmpty()) {
            Entry<Double, FlightEvent> nextEvent = eventManagementQueue.removeMin();
            System.out.println("Time: " + nextEvent.getKey() + "Event Type: " + nextEvent.getValue());
        }
    }
}
