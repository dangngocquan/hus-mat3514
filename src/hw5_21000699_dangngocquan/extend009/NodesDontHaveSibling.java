package hw5_21000699_dangngocquan.extend009;

import java.util.ArrayList;
import java.util.TreeSet;

// Link: https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
public class NodesDontHaveSibling {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Tree {
        ArrayList<Integer> noSibling(Node node) {
            ArrayList<Integer> list = new ArrayList<>();
            noSibling(node, list);
            if (list.size() == 0) list.add(-1);
            return new ArrayList<>(new TreeSet<>(list));
        }

        public void noSibling(Node node, ArrayList<Integer> list) {
            if (node == null) return;
            if (node.left == null && node.right == null) return;
            if (node.left == null) list.add(node.right.data);
            if (node.right == null) list.add(node.left.data);
            noSibling(node.left, list);
            noSibling(node.right, list);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(5);
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new Tree().noSibling(node1)); // [1, 2]
    }
}
