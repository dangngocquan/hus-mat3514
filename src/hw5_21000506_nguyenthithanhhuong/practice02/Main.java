package hw5_21000506_nguyenthithanhhuong.practice02;

public class Main {
    static class Node {
        int data;
        Node left,right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Find height of tree
    static class Solution {
        int height(Node node) {
            if (node == null) return 0;
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    public static void main(String[] args) {
        /*
        * Input tree
        *    1
        *   / \
        *  2   3
        */
        Node nodeRoot = new Node(1);
        Node nodeLeft = new Node(2);
        Node nodeRight = new Node(3);

        nodeRoot.left = nodeLeft;
        nodeRoot.right = nodeRight;

        Solution solution = new Solution();

        // Height of input tree
        System.out.println(solution.height(nodeRoot)); // 2
    }
}
