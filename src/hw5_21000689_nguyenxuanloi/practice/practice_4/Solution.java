package hw5_21000689_nguyenxuanloi.practice.practice_4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new Solution().createRootFromArray(3,9,20,null,null,15,7);
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) { // copy this part to run on web
        if (root == null) {
            return 0;
        }
        if (root.left != null
                && root.left.left == null
                && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public TreeNode createRootFromArray(Integer... arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        int idx = 1;

        while (!nodes.isEmpty()) {
            if (idx < arr.length && arr[idx] != null) {
                TreeNode leftChild = new TreeNode(arr[idx]);
                nodes.peek().setLeft(leftChild);
                nodes.add(leftChild);
            }
            idx++;
            if (idx < arr.length && arr[idx] != null) {
                TreeNode rightChild = new TreeNode(arr[idx]);
                nodes.peek().setRight(rightChild);
                nodes.add(rightChild);
            }
            nodes.poll();
            idx++;
        }

        return root;
    }
}
