package hw3_21000676_damhaidang.ex3;

import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T> {
    class Node {
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
        }
        public boolean hasNext() {
            return next != null;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;
    public void add(T data) {
        if (top == null) {
            top = new Node(data);
        } else {
            Node temp = top;
            while (temp.hasNext()) {
                temp = temp.next;
            }
            temp.next = new Node(data);
            bot = new Node(data);
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data);
        bot.next = newNode;
        bot = newNode;
        n++;
    }

    public T get(int i) throws IllegalArgumentException {
        if (i >= n) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node result = top;
        for (int idx = 0; idx < i; idx++) {
            result = result.next;
        }
        return result.data;
    }

    public void set(int i ,T data) {
        Node temp = top;
        for (int idx = 0; idx < i - 1; idx++) {
            temp = temp.next;
        }
        temp.next.data = data;
    }

    public boolean isContain(T data) {
        Node temp = top;
        while (temp.hasNext()) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
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
        Node temp = top;
        top = top.next;
        n--;
        return temp.data;
    }

    public T removeBot() {
        Node temp = top;
        for (int idx = 0; idx < n - 1; idx++) {
            temp = temp.next;
        }
        Node result = temp.next;
        temp.next = null;
        bot = temp;
        n--;
        return result.data;
    }

    public void remove(T data) {
        Node temp = top;
        while (temp.hasNext()) {
            if (temp.next.data == data) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        n--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int counter = 0;
            public boolean hasNext() {
                return counter < size();
            }
            public T next() {
                return get(counter++);
            }
        };
    }
}