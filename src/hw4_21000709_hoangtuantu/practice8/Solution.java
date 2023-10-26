package hw4_21000709_hoangtuantu.practice8;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        requests.offer(t);

        return requests.size();
    }
}

public class Solution {
}
