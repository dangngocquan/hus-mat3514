package hw6_22001273_nguyenhoangminh.exercise5.airplanemanager;

import hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue.SortedArrayPriorityQueue;

public class FlightManager {
    private SortedArrayPriorityQueue<Time, Flight> departure, arrival;

    public FlightManager(int capacity) {
        this.departure = new SortedArrayPriorityQueue<>(capacity);
        this.arrival = new SortedArrayPriorityQueue<>(capacity);
    }

    public void registerDeparture(Flight flight, int hour, int minute) {
        flight.setDepart(hour, minute);
        departure.insert(flight.getDepart(), flight);
    }

    public void registerArrival(Flight flight, int hour, int minute) {
        flight.setArrive(hour, minute);
        arrival.insert(flight.getArrive(), flight);
    }

    public Flight nextDeparture() {
        return departure.min().getValue();
    }

    public Flight nextArrival() {
        return arrival.min().getValue();
    }

    public Flight removeDeparted() {
        Flight temp = departure.min().getValue();
        departure.removeMin();

        return temp;
    }

    public Flight removeArrived() {
        Flight temp = arrival.min().getValue();
        arrival.removeMin();

        return temp;
    }

    public void display() {
        System.out.println("Departure:");
        for (int i = departure.size() - 1; i >= 0; i--) {
            System.out.print(departure.get(i).getValue().toString()
                    + " - " + departure.get(i).getKey().toString());
            System.out.println();
        }
        System.out.println("Arrival:");
        for (int i = departure.size() - 1; i >= 0; i--) {
            System.out.print(arrival.get(i).getValue().toString()
                    + " - " + arrival.get(i).getKey().toString());
            System.out.println();
        }
    }
}
