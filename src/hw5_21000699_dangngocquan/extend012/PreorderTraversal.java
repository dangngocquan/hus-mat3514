package hw5_21000699_dangngocquan.extend012;

import java.util.ArrayList;

// Link: https://practice.geeksforgeeks.org/problems/preorder-traversal/1
public class PreorderTraversal {
     static class Node {
         int data;
         Node left, right;

         Node(int d){
             data = d;
             left = right = null;
         }
     }

    static class BinaryTree {
        // Function to return a list containing the preorder traversal of the tree.
        static ArrayList<Integer> preorder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            preorder(root, list);
            return list;
        }

        static void preorder(Node node, ArrayList<Integer> list) {
            if (node == null) return;
            list.add(node.data);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        /*
        *           0
        *       2       3
        *   4
        *
        * */

        System.out.println(BinaryTree.preorder(node1)); // [0, 2, 4, 3]
    }
}
