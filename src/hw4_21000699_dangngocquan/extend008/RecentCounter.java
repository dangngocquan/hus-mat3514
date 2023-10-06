package hw4_21000699_dangngocquan.extend008;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        int min = t - 3000;
        while (!queue.isEmpty() && queue.peek() < min) queue.poll();
        queue.add(t);
        return queue.size();
    }
}