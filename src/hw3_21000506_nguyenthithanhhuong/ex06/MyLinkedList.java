package hw3_21000506_nguyenthithanhhuong.ex06;

public class MyLinkedList {
    class Node<T> {
        T data;
        Node next;
    }

    private Node<Integer> head;
    private int n;

    public MyLinkedList() {

    }

    public int get(int index) {
        Node<Integer> node = getNode(index);
        if (node == null) return -1;
        return node.data;
    }

    public void addAtHead(int val) {
        Node<Integer> node = new Node<>();
        node.data = val;
        node.next = head;
        head = node;
        n++;
    }

    public void addAtTail(int val) {
        Node<Integer> node = new Node<>();
        node.data = val;
        if (n == 0) {
            head = node;
        } else {
            getNode(n - 1).next = node;
        }
        n++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > n) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == n) {
            addAtTail(val);
            return;
        }
        Node<Integer> node = new Node<>();
        node.data = val;
        node.next = getNode(index);
        getNode(index-1).next = node;
        n++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) return;
        if (index == 0) {
            head = getNode(1);
            n--;
            return;
        }
        if (index == n - 1) {
            getNode(n - 2).next = null;
            n--;
            return;
        }
        getNode(index - 1).next = getNode(index + 1);
        n--;
    }

    private Node<Integer> getNode(int index) {
        if (index < 0 || index >= n) {
            return null;
        }
        Node node = new Node<>();
        node = head;
        for (int j = 0; j < index; j++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = new Node();
        node = head;
        for (int i = 0; i < n; i++) {
            sb.append(node.data).append(", ");
            node = node.next;
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }
}
