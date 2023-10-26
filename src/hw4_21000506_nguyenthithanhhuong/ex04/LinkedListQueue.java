package hw4_21000506_nguyenthithanhhuong.ex04;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    public class Node {
        E data;
        Node next;
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        Node node = new Node();
        node.data = element;
        if (isEmpty()) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    @Override
    public E first() {
        if (first == null) return null;
        return first.data;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E result = first.data;
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return result;
        }
        first = first.next;
        size--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    private class LinkedListQueueIterator implements Iterator<E> {
        Node currentNode = first;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E result = currentNode.data;
            currentNode = currentNode.next;
            return result;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next()). append(", ");
        }

        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }
}
