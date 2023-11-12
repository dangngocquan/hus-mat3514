package hw5_21000117_nguyenquochieu.sessionC.practice20;

public class Solution {
    /*
    This is the code I have submitted on the website
    -----------------------------------------------
    public static Tree convert(Node head, Tree node) {
        Queue<Tree> queue = new LinkedList<>();
        if (head == null) {
            node = null;
            return null;
        }
        node = new Tree(head.data);
        queue.add(node);
        head = head.next;
        while (head != null) {
            Tree tree = queue.peek();
            Tree left = null;
            Tree right = null;
            left = new Tree(head.data);
            queue.add(left);
            head = head.next;
            if (head != null) {
                right = new Tree(head.data);
                queue.add(right);
                head = head.next;
            }
            tree.left = left;
            tree.right = right;
            queue.poll();
        }
        return node;
    }
     */
}
