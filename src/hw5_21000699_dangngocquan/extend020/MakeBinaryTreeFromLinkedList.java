package hw5_21000699_dangngocquan.extend020;

import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/make-binary-tree/1
public class MakeBinaryTreeFromLinkedList {
    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static class GfG {
        // Function to make binary tree from linked list.
        public static Tree convert(Node head, Tree node) {
            if (node == null) node = new Tree(head.data);
            node.data = head.data;
            Tree root = node;
            head = head.next;
            Queue<Tree> queue = new LinkedList<>();
            int index = 1;
            while (head != null) {
                Tree newNode = new Tree(head.data);
                queue.add(newNode);
                if (index % 2 == 1) {
                    node.left = newNode;
                } else {
                    node.right = newNode;
                    node = queue.poll();
                }
                head = head.next;
                index++;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Tree tree = GfG.convert(node1, null);
        System.out.println(tree.data); // 1
        System.out.println(tree.left.data); // 2
        System.out.println(tree.right.data); // 3
        System.out.println(tree.left.left.data); // 4
        System.out.println(tree.left.right.data); // 5
    }
}
