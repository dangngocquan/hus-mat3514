package hw5_21000699_dangngocquan.extend010;

// Link: https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
public class CheckIdenticalTrees {

    static class Node{
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Solution {
        // Function to check if two trees are identical.
        boolean isIdentical(Node root1, Node root2) {
            // Code Here
            if (root1 == null && root2 == null) return true;
            if (root1 == null) return false;
            if (root2 == null) return false;
            if (root1.data != root2.data) return false;
            return isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right);
        }
    }

    public static void main(String[] args) {
        Node node11 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        node11.left = node12;
        node11.right = node13;

        Node node21 = new Node(1);
        Node node22 = new Node(2);
        Node node23 = new Node(3);
        node21.left = node22;
        node21.right = node23;

        System.out.println(new Solution().isIdentical(node11, node21)); // true
    }
}
