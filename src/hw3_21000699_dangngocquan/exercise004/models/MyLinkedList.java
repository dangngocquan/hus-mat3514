package hw3_21000699_dangngocquan.exercise004.models;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    @Override
    public void add(T data) {
        if (n == 0) {
            top = new Node();
            top.data = data;
            bot = top;
        } else {
            bot.next = new Node();
            bot = bot.next;
        }
        bot.data = data;
        n++;
    }

    @Override
    public T get(int i) {
        return getNode(i).data;
    }

    @Override
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

    @Override
    public boolean isContain(T data) {
        Node node = top;
        while (node != null) {
            if (node.data.equals(data)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int indexOf(T data) {
        Node node = top;
        int index = -1;
        while (node != null) {
            index++;
            if (node.data.equals(data)) return index;
            node = node.next;
        }
        return index;
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

    @Override
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    Node node = currentNode;
                    currentNode = currentNode.next;
                    return node.data;
                } else {
                    return null;
                }
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }
        if (sb.length() > 1) sb.delete(sb.length()-2, sb.length());
        sb.append("}");
        return sb.toString();
    }
}
