package hw5_21000699_dangngocquan.extend005;

// Link: https://leetcode.com/problems/univalued-binary-tree/
public class UnivaluedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1, node4, node5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(new Solution().isUnivalTree(node1));
    }

}

