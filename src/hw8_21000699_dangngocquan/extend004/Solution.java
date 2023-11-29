package hw8_21000699_dangngocquan.extend004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[V];
        Arrays.fill(isVisited, false);
        queue.add(0);
        output.add(0);
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer neighbour : adj.get(vertex)) {
                if (!isVisited[neighbour]) {
                    queue.add(neighbour);
                    output.add(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
        return output;
    }
}
