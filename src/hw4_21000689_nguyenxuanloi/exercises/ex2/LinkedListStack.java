package hw4_21000689_nguyenxuanloi.exercises.ex2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
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

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;


        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E element = currentNode.getElement();
            currentNode = currentNode.next;
            return element;
        }
    }

    private Node stack = null;
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
    public void push(E element) {
        stack = new Node(element, stack);
        size++;
    }

    @Override
    public E top() {
        return stack.getElement();
    }

    @Override
    public E pop() {
        E element = stack.getElement();
        stack = stack.next;
        size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
}
