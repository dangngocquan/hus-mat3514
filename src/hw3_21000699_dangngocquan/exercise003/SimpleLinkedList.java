package hw3_21000699_dangngocquan.exercise003;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        if (n == 0) {
            top = new Node();
            top.data = data;
            bot = new Node();
        } else {
            bot.next = new Node();
            bot = bot.next;
        }
        bot.data = data;
        n++;
    }

    public T get(int i) {
        return getNode(i).data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node node = top;
            while (i-- > 0) {
                node = node.next;
            }
            node.data = data;
        }
    }

    public boolean isContain(T data) {
        Node node = top;
        while (node != null) {
            if (node.data.equals(data)) return true;
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
        if (n == 0) return null;
        T data = top.data;
        if (n == 1) {
            top = null;
            bot = null;
        } else if (n > 1) {
            top = top.next;
        }
        n--;
        return data;
    }

    public T removeBot() {
        if (n == 0) return null;
        T data = bot.data;
        if (n == 1) {
            top = null;
            bot = null;
        } else if (n > 1) {
           bot = getNode(n-2);
        }
        n--;
        return data;
    }

    public void remove(T data) {
        if (top == null) return;
        if (top.data.equals(data)) {
            top = top.next;
            n--;
            return;
        }
        Node node = top;
        while (node.next != null) {
            if (node.next.data.equals(data)) {
                node.next = node.next.next;
                n--;
                return;
            }
            node = node.next;
        }
    }

    private Node getNode(int i) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node node = top;
            while (i-- > 0) {
                node = node.next;
            }
            return node;
        }
    }
}
