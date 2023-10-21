package hw5_21000699_dangngocquan.extend014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/level-order-traversal/1
public class LevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Solution {
        // Function to return the level order traversal of a tree.
        static ArrayList<Integer> levelOrder(Node node) {
            // Your code here
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Node> queueNodes = new LinkedList<>();
            if (node != null) queueNodes.add(node);
            while (!queueNodes.isEmpty()) {
                Node currentNode = queueNodes.poll();
                list.add(currentNode.data);
                if (currentNode.left != null) queueNodes.add(currentNode.left);
                if (currentNode.right != null) queueNodes.add(currentNode.right);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        /*
         *           0
         *       1      2
         *   4
         *
         * */

        System.out.println(Solution.levelOrder(node1)); // [0, 1, 2, 4]
    }
}
