package hw5_21000506_nguyenthithanhhuong.practice20;

import java.util.LinkedList;
import java.util.Queue;

// Make binary tree from linked list
public class Main {
    static class Tree{
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            data = data;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;
        Node(int data) {
            data = data;
            next = null;
        }
    }

    static class GfG {
        public static Tree convert(Node head, Tree node) {
            Queue<Tree> treeQueue = new LinkedList<Tree>();

            if (head == null) {
                node = null;
                return null;
            }

            if (node == null) {
                node = new Tree(head.data);
            }
            treeQueue.add(node);

            head = head.next;

            while (head != null) {
                Tree parent = node;
                parent = treeQueue.peek();

                Tree left = new Tree(head.data);
                treeQueue.add(left);
                parent.left = left;
                head = head.next;

                if (head != null) {
                    Tree right = new Tree(head.data);
                    treeQueue.add(right);
                    parent.right = right;
                    head = head.next;
                }
                treeQueue.poll();
            }
            return node;
        }
    }
}
