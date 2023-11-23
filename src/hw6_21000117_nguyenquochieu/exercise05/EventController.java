package hw6_21000117_nguyenquochieu.exercise05;

import hw6_21000117_nguyenquochieu.exercise01.Entry;
import hw6_21000117_nguyenquochieu.exercise01.UnsortedArrayPriorityQueue;

public class EventController {
    private UnsortedArrayPriorityQueue<TimeController, Event> queue = new UnsortedArrayPriorityQueue<>();
    private int numEvents = 0;

    public EventController() {
    }

    public void addEvent(Event event) {
        queue.insert(event.getTimeStamp(), event);
        numEvents ++;
    }

    public void reset() {
        while (((TimeController) queue.min().getKey()).compareToPresent() < 0) {
            numEvents --;
            queue.removeMin();
        }
    }
    public Entry getNextEvent() {
        reset();
        numEvents --;
        return queue.removeMin();
    }
}
