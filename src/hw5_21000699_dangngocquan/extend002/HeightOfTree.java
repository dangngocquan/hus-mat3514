package hw5_21000699_dangngocquan.extend002;

public class HeightOfTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Solution {
        // Function to find the height of a binary tree.
        int height(Node node) {
            // Code here
            if (node == null) return 0;
            return 1 + Math.max(
                    height(node.left),
                    height(node.right)
            );
        }
    }

    // Test
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        System.out.println(new Solution().height(node));
    }
}
