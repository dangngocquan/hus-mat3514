package hw5_21000699_dangngocquan.extend016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
public class DiagonalTraversalOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Tree {
        public ArrayList<Integer> diagonal(Node root) {
            // Add your code here.
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                while (node != null) {
                    list.add(node.data);
                    if (node.left != null) queue.add(node.left);
                    node = node.right;
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node4.right = node6;
        node5.left = node7;
        /*
        *                       1
        *           2                       3
        *               4               5
        *                   6       7
        *
        * */

        System.out.println(new Tree().diagonal(node1)); // [1, 3, 2, 4, 6, 5, 7]
    }
}
