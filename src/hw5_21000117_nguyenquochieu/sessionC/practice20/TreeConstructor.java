package hw5_21000117_nguyenquochieu.sessionC.practice20;

import java.util.LinkedList;
import java.util.Queue;

public class TreeConstructor {
    private int index = 0;
    public static Tree convert(Node head, Tree node) {
        Queue<Tree> queue = new LinkedList<>();
        if (head == null) {
            node = null;
            return null;
        }
        node = new Tree(head.getData());
        queue.add(node);
        head = head.getNext();
        while (head != null) {
            Tree tree = queue.peek();
            Tree left = null;
            Tree right = null;
            left = new Tree(head.getData());
            queue.add(left);
            head = head.getNext();
            if (head != null) {
                right = new Tree(head.getData());
                queue.add(right);
                head = head.getNext();
            }
            tree.setLeft(left);
            tree.setRight(right);
            queue.poll();
        }
        return node;
    }
}
