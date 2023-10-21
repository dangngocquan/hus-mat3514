package hw5_21000699_dangngocquan.extend007;

// Link: https://practice.geeksforgeeks.org/problems/count-non-leaf-nodes-in-tree/1
public class CountNonLeafNodesInTree {
    static class Node {
        int data;
        Node left,right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    // Function should return the count of total number of non leaf nodes in the tree.
    static class Solution {
        int countNonLeafNodes(Node root) {
            // Code here
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            return 1 + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(new Solution().countNonLeafNodes(node1)); // 2
    }
}
