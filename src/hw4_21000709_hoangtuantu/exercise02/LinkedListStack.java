package hw4_21000709_hoangtuantu.exercise02;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E> {
    class Node{
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
    private Node head = null;
    private int size = 0;

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (head != null){
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (head == null){
            throw new NullPointerException();
        }
        E data = head.element;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E top() {
        return head.element;
    }

    @Override
    public String toString() {
        if (head == null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Node          node   = head;
        while (node != null){
            result.insert(0, node.element + ", ");
            node = node.next;
        }
        return result.toString();
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E data = node.element;
            node = node.next;
            return data;
        }
    }

}
