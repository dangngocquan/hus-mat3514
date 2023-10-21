package hw5_21000699_dangngocquan.extend011;

import java.util.ArrayList;

// Link: https://practice.geeksforgeeks.org/problems/inorder-traversal/1
public class InorderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Solution {
        // Function to return a list containing the inorder traversal of the tree.
        ArrayList<Integer> inOrder(Node root) {
            // Code
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        public void inOrder(Node node, ArrayList<Integer> list) {
            if (node == null) return;
            inOrder(node.left, list);
            list.add(node.data);
            inOrder(node.right, list);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(new Solution().inOrder(root));
        // [2, 1, 3]
    }
}
