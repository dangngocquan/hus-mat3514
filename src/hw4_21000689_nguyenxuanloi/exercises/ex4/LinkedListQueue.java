package hw4_21000689_nguyenxuanloi.exercises.ex4;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    @Override
    public void enqueue(E element) {
        if (tail == null) {
            tail = new Node(element, null);
            head = tail;
        } else {
            Node bot = new Node(element, null);
            tail.setNext(bot);
            tail = bot;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = head.getElement();
        head = head.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<E> {
        private Node currentNode = head;


        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E element = currentNode.getElement();
            currentNode = currentNode.getNext();
            return element;
        }
    }
}
