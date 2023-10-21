package hw5_21000699_dangngocquan.extend003;

// Link: https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
public class CountLeavesInBinaryTree {
    static class Node {
        int data;
        Node left, right;
    }

    static class Tree {
        int countLeaves(Node node) {
            // Your code
            if (node == null) return 0;
            if (node.left == null && node.right == null) return 1;
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node2.data = 2;
        Node node3 = new Node();
        node3.data = 3;
        Node node4 = new Node();
        node4.data = 4;
        Node node5 = new Node();
        node5.data = 5;

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(new Tree().countLeaves(node1));
    }
}
