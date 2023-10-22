package hw5_21000699_dangngocquan.extend018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static class Tree {
        // Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                int k = queue.size();
                Node node = queue.poll();
                list.add(node.data);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                k--;
                while (k-- > 0) {
                    node = queue.poll();
                    assert node != null;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;

        /*
        *                           0
        *           2                               3
        *                   4
        *               5
        *
        * */

        System.out.println(new Tree().leftView(node1)); // [0, 2, 4, 5]
    }
}
