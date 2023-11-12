package hw5_21000506_nguyenthithanhhuong.practice11;

import java.util.ArrayList;

public class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Solution {
        ArrayList<Integer> inOrder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            return list;
        }
        // print in-order traversal
        void inorderTraversal(Node root, ArrayList<Integer> list) {
            if (root == null) return;
            inorderTraversal(root.left, list);
            list.add(root.data);
            inorderTraversal(root.right, list);
        }
    }

    public static void main(String[] args) {
        /*
         * Input tree
         *    1
         *   / \
         *  2   3
         */
        Main.Node nodeRoot = new Node(1);
        Node nodeLeft = new Node(2);
        Node nodeRight = new Node(3);

        nodeRoot.left = nodeLeft;
        nodeRoot.right = nodeRight;

        Solution solution = new Solution();

        // in-order print
        System.out.println(solution.inOrder(nodeRoot)); // [2, 1, 3]
    }
}
