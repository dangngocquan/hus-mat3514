package hw5_21000699_dangngocquan.extend015;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class ZigZagTreeTraversal {
    static class Node {
        int data;
        Node left,right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class GFG {
        // Function to store the zigzag order traversal of tree in a list.
        ArrayList<Integer> zigZagTraversal(Node root) {
            // Add your code here.
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            if (root != null) queue.add(root);
            int level = 1;
            int numberNode = 1;
            while (!queue.isEmpty()) {
                int nextLevel = level + 1;
                int nextNumberNode = 0;
                int prevListSize = list.size();
                while (numberNode-- > 0) {
                    Node node = queue.poll();
                    assert node != null;
                    int indexAdd = level % 2 == 1? list.size() : prevListSize;
                    list.add(indexAdd, node.data);
                    if (node.left != null) {
                        queue.add(node.left);
                        nextNumberNode++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        nextNumberNode++;
                    }
                }
                level = nextLevel;
                numberNode = nextNumberNode;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        /*
         *           0
         *       3      4
         *   5
         *
         * */

        System.out.println(new GFG().zigZagTraversal(node1)); // [0, 4, 3, 5]
    }
}
