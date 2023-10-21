package hw5_21000699_dangngocquan.extend013;

import java.util.ArrayList;

// Link: https://practice.geeksforgeeks.org/problems/postorder-traversal/1
public class PostorderTraversal {
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
        static ArrayList<Integer> postOrder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            postOrder(root, list);
            return list;
        }

        static void postOrder(Node node, ArrayList<Integer> list) {
            if (node == null) return;
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.data);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        /*
         *           0
         *       1      3
         *   4
         *
         * */

        System.out.println(BinaryTree.postOrder(node1)); // [4, 1, 3, 0]
    }
}
