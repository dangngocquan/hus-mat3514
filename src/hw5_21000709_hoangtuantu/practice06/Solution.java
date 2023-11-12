package hw5_21000709_hoangtuantu.practice06;
class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {
    public int getSize(Node node) {
        if (node == null)
            return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }
}

