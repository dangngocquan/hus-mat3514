package hw5_21000709_hoangtuantu.practice07;

class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {
    public int countNonLeafNodes(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
    }
}
