package hw5_21000709_hoangtuantu.practice02;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    public int height(Node node) {
        if (node == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int output = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }
            output++;
        }
        return output;
    }
}
