package hw4_22001273_nguyenhoangminh.excercise4;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E e, Node n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node getNext() { return next; }
        public void setNext(Node n) {
            next = n;
        }
    }

    private Node top = null;
    private int size = 0;

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    public E get(int n) {
        Node current = top;
        for (int i = 0; i < n; ++i) {
            current = current.getNext();
        }
        return current.getElement();
    }

    @Override
    public void enqueue(E element) {
        top = new Node(element, top);
        size++;
    }

    @Override
    public E dequeue() {
        Node current = top;
        for (int i = 1; i < size - 1; ++i) {
            current = current.getNext();
        }
        E answer = current.getNext().getElement();
        current.setNext(null);
        size--;
        return answer;
    }

    @Override
    public E first() {
        return top.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    public class LinkedListQueueIterator implements Iterator<E> {
        Node currentNode = top;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.getElement();
            currentNode = currentNode.getNext();
            return data;
        }
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            queue.append(get(i));
            queue.append(" | ");
        }
        return queue.toString();
    }
}
