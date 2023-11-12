package hw5_21000712_taquangtung.itemA.practice02;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Tính chiều cao của cây
    int height(Node node) {
        // code here
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}
