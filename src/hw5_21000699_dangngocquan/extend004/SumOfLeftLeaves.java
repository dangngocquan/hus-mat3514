package hw5_21000699_dangngocquan.extend004;

// Link: https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int sum = 0;
            if (root.left != null)
                sum += isLeavesNode(root.left)? root.left.val : sumOfLeftLeaves(root.left);
            sum += sumOfLeftLeaves(root.right);
            return sum;
        }

        public boolean isLeavesNode(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(new Solution().sumOfLeftLeaves(node1)); // 6
    }
}
