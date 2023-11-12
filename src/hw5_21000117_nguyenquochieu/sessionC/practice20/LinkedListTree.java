package hw5_21000117_nguyenquochieu.sessionC.practice20;

public class LinkedListTree {
    private Node head;
    public Node getHead() {
        return head;
    }
    public void add(int element) {
        if (head == null) head = new Node(element);
        else {
            Node node = new Node(element);
            node.setNext(head);
            head = node;
        }
    }
}
