package hw4_21000117_nguyenquochieu.practice08;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> requests;
    private int lowerBound;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.add(t);
        lowerBound = t - 3000;
        while (!requests.isEmpty() && requests.peek() < lowerBound) {
            requests.poll();
        }
        return requests.size();
    }

}
