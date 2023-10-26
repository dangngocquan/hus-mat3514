package hw4_21000676_damhaidang.ex5;

import hw4_21000676_damhaidang.ex4.ListInterface;

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
        Node node = new Node(data);
        if (top == null) {
            top = node;
        }
        if (bot != null) {
            bot.next = node;
        }
        bot = node;
        n++;
    }

    public void addBot(T data) {
        add(data);
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

    public void set(int i, T data) {
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
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T result = temp.next.data;
        temp.next = null;
        bot = temp;
        n--;
        return result;
    }

    public void remove(T data) {
        Node curr = top;
        int count = 0;
        while (curr != null) {
            Node next = curr.next;
            while (next != null && next.data == data) {
                next = next.next;
                count++;
            }
            curr.next = next;
            curr = next;
        }
        n -= count;
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