package hw5_21000699_dangngocquan.extend017;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
     static class Node {
         int data;
         Node left, right;

         public Node(int d) {
             data = d;
             left = right = null;
         }
     }

    static class Solution {
        ArrayList<Integer> boundary(Node node) {
            ArrayList<Integer> list = new ArrayList<>();
            boundary(node, 0, list);
            return list;
        }

        public void boundary(Node node, int typeNode, ArrayList<Integer> list) {
            if (node == null) return;
            if (typeNode == 0) {
                list.add(node.data);
                boundary(node.left, 1, list);
                boundary(node.left, 2, list);
                boundary(node.right, 2, list);
                boundary(node.right, 3, list);
                return;
            }
            if (node.left == null && node.right == null) {
                if (typeNode == 2) list.add(node.data);
                return;
            }
            if (typeNode == 2) {
                boundary(node.left, 2, list);
                boundary(node.right, 2, list);
                return;
            }
            if (typeNode == 1) {
                list.add(node.data);
                boundary(node.left != null? node.left : node.right, 1, list);
            }
            if (typeNode == 3) {
                boundary(node.right != null? node.right: node.left, 3, list);
                list.add(node.data);
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.left.right.left = new Node(7);
        node1.left.right.right = new Node(8);
        node1.right = new Node(3);
        node1.right.right = new Node(6);

        /*
        *
        *                           1
        *           2                               3
        *   4               5                               6
        *               7       8
        *
        * */
        System.out.println(new Solution().boundary(node1)); // [1, 2, 4, 7, 8, 6, 3]
    }
}
