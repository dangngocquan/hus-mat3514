package hw3_21000506_nguyenthithanhhuong.ex03;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node node = new Node();
        if (n == 0) {
            top = node;
            top.data = data;
            bot = node;
        } else {
            bot.next = node;
            bot = bot.next;
        }
        bot.data = data;
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return getNode(i).data;
        }
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node node = top;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            node.data = data;
        }
    }

    public boolean isContain(T data) {
        Node node = top;
        for (int j = 0; j < n; j++) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        T res = top.data;
        if (n == 0) return null;
        if (n == 1) {
            top = null;
            bot = null;
        } else {
            top = top.next;
        }
        n--;
        return res;
    }

    public T removeBot() {
        T res = bot.data;
        if (n == 0) return null;
        if (n == 1) {
            top = null;
            bot = null;
        } else {
            bot = getNode(n - 2);
        }
        n--;
        return null;
    }

    public void remove(T data) {
        if (n == 0) return;
        if (top.data.equals(data)) {
            top = top.next;
            n--;
            return;
        }
        Node node = top;
        Node deleteNode = null;
        while (node != null) {
            if (node.next.data.equals(data) && node.next != null) {
                deleteNode = node.next;
                node.next = deleteNode.next;
                n--;
                return;
            }
            node = node.next;
        }
    }

    public Node getNode(int i) {
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node;
    }
}
