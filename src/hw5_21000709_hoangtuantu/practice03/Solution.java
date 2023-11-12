package hw5_21000709_hoangtuantu.practice03;

class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {
    public int countLeaves(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }
}

