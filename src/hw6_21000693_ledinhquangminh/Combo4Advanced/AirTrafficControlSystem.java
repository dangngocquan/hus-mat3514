package hw6_21000693_ledinhquangminh.Combo4Advanced;

import java.util.PriorityQueue;

public class AirTrafficControlSystem {
    public static void main(String[] args) {
        PriorityQueue<Event> takeOffQueue = new PriorityQueue<>();
        PriorityQueue<Event> landingQueue = new PriorityQueue<>();

        // Add events to the queues
        addEvent(takeOffQueue, "Flight 1", 10, EventType.TAKEOFF);
        addEvent(takeOffQueue, "Flight 2", 5, EventType.TAKEOFF);
        addEvent(landingQueue, "Flight 3", 8, EventType.LANDING);
        addEvent(landingQueue, "Flight 4", 18, EventType.LANDING);

        // Simulate air traffic control
        handleAirTraffic(takeOffQueue, landingQueue);
    }

    private static void addEvent(PriorityQueue<Event> queue, String flight, int time, EventType type) {
        Event event = new Event(flight, time, type);
        queue.add(event);
    }

    private static void handleAirTraffic(PriorityQueue<Event> takeOffQueue, PriorityQueue<Event> landingQueue) {
        while (!takeOffQueue.isEmpty() || !landingQueue.isEmpty()) {
            Event nextTakeOff = takeOffQueue.peek();
            Event nextLanding = landingQueue.peek();

            if (nextTakeOff != null && nextLanding != null) {
                if (nextTakeOff.getTime() <= nextLanding.getTime()) {
                    System.out.println("Preparing for takeoff: " + nextTakeOff.getFlight());
                    takeOffQueue.poll();
                } else {
                    System.out.println("Preparing for landing: " + nextLanding.getFlight());
                    landingQueue.poll();
                }
            } else if (nextTakeOff != null) {
                System.out.println("Preparing for takeoff: " + nextTakeOff.getFlight());
                takeOffQueue.poll();
            } else {
                System.out.println("Preparing for landing: " + nextLanding.getFlight());
                landingQueue.poll();
            }
        }
    }

    static class Event implements Comparable<Event> {
        private String flight;
        private int time;
        private EventType type;

        public Event(String flight, int time, EventType type) {
            this.flight = flight;
            this.time = time;
            this.type = type;
        }

        public String getFlight() {
            return flight;
        }

        public int getTime() {
            return time;
        }

        public EventType getType() {
            return type;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(time, other.time);
        }
    }

    enum EventType {
        TAKEOFF, LANDING
    }
}

