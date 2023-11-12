package hw5_21000689_nguyenxuanloi.practice.practice_20;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeCreator {
    public static void main(String[] args) {

    }

    public static Tree convert(Node head, Tree node) { // copy this part to run on web
        if (head == null) {
            return null;
        }
        node = new Tree(head.data);
        Queue<Tree> treeNodes = new ArrayDeque<>();
        treeNodes.add(node);

        while (!treeNodes.isEmpty()) {
            Tree root = treeNodes.poll();
            if (head.next != null) {
                head = head.next;
                Tree leftChild = new Tree(head.data);
                root.left = leftChild;
                treeNodes.add(leftChild);
            }
            if (head.next != null) {
                head = head.next;
                Tree rightChild = new Tree(head.data);
                root.right = rightChild;
                treeNodes.add(rightChild);
            }
        }

        return node;
    }
}
