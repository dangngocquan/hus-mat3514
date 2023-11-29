package hw8_21000699_dangngocquan.extend002;

import java.util.*;

public class Solution {
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    Node cloneGraph(Node node){
        if (node == null) return null;
        Map<Node, Node> map = new LinkedHashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node node0 = queue.poll();
            for (Node neighbour : node0.neighbors) {
                if (map.containsKey(neighbour)) continue;
                map.put(neighbour, new Node(neighbour.val));
                queue.add(neighbour);
            }
        }
        for (Node node0 : map.keySet()) {
            for (Node neighbour : node0.neighbors) {
                map.get(node0).neighbors.add(map.get(neighbour));
            }
        }

        Iterator<Node> iterator = map.values().iterator();
        return iterator.next();
    }
}
