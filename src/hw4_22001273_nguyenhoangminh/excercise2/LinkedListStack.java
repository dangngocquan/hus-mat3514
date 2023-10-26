package hw4_22001273_nguyenhoangminh.excercise2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E e, Node n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node getNext() { return next; }
        public void setNext(Node n) { next = n; }
    }
    private Node top = null;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E get(int n) {
        Node current = top;
        for (int i = 0; i < n; ++i) {
            current = current.getNext();
        }
        return current.getElement();
    }

    @Override
    public void push(E element) {
        top = new Node(element, top);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
        size--;
        return temp.getElement();
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return top.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {
        private Node currentNode = top;

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
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            stack.append(get(i));
            stack.append(" | ");
        }
        return stack.toString();
    }
}
