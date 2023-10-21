package hw5_21000699_dangngocquan.extend008;

// Link: https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
public class MinimumDepthOfABinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Solution {
        int minDepth(Node root) {
            // Code here
            if (root == null) return 0;
            if (root.left == null) return 1 + minDepth(root.right);
            if (root.right == null) return 1 + minDepth(root.left);
            return 1 + Math.min(
                    minDepth(root.left),
                    minDepth(root.right)
            );
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(new Solution().minDepth(node1)); // 2
    }
}
