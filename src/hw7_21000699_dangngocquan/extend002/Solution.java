package hw7_21000699_dangngocquan.extend002;

public class Solution {
    boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data > max || root.data < min) return false;
        if (root.left != null && root.left.data >= root.data) return false;
        if (root.right != null && root.right.data <= root.data) return false;
        return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
