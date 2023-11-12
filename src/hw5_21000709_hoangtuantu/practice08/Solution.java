package hw5_21000709_hoangtuantu.practice08;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {
    public int minDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int output = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node node = q.poll();
                if (node.left == null && node.right == null)
                    return output;
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
