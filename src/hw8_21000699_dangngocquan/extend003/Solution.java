package hw8_21000699_dangngocquan.extend003;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> output = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        output.add(0);
        isVisited[0] = true;
        dfsOfGraph(0, adj, output, isVisited);
        return output;
    }

    public void dfsOfGraph(
            int vertex, ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> output, boolean[] isVisited) {
        for (Integer neighbour : adj.get(vertex)) {
            if (isVisited[neighbour]) continue;
            output.add(neighbour);
            isVisited[neighbour] = true;
            dfsOfGraph(neighbour, adj, output, isVisited);
        }
    }
}
