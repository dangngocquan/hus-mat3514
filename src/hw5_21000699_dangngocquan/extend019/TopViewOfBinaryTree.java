package hw5_21000699_dangngocquan.extend019;

import java.util.ArrayList;

// Link: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static class Solution {
        static int rootIndex;

        // Function to return a list of nodes visible from the top view
        // from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root) {
            rootIndex = -1;
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> levels = new ArrayList<>();
            topView(root, 0, 1, list, levels);
            return list;
        }

        public static void topView(
                Node node, int diffRoot, int level,
                ArrayList<Integer> list,
                ArrayList<Integer> levels) {
            if (node == null) return;
            int index = diffRoot + rootIndex;
            if (index >= 0 && index < list.size()) {
                if (level < levels.get(index)) {
                    list.set(index, node.data);
                    levels.set(index, level);
                }
            } else {
                if (index == -1) rootIndex -= index++;
                list.add(index, node.data);
                levels.add(index, level);
            }
            topView(node.left, diffRoot - 1, level + 1, list, levels);
            topView(node.right, diffRoot + 1, level + 1, list, levels);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;

        /*
         *                           1
         *           3                               4
         *                   5
         *               6
         *
         * */

        System.out.println(Solution.topView(node1)); // [3, 1, 4]
    }
}
