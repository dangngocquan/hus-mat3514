package hw5_21000699_dangngocquan.extend006;

// Link: https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1
public class SizeOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Tree {
        public static int getSize(Node root) {
            // Add code here.
            if (root == null) return 0;
            return 1 + getSize(root.left) + getSize(root.right);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(Tree.getSize(node1)); // 5
    }
}
