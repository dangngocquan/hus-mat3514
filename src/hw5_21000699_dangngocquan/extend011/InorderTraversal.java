package hw5_21000699_dangngocquan.extend011;

import java.util.ArrayList;

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
            if (root != null) {
                list.addAll(inOrder(root.left));
                list.add(root.data);
                list.addAll(inOrder(root.right));
            }
            return list;
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
