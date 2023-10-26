package hw4_21000117_nguyenquochieu.exercise02;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node{
        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        E element;
        Node next;
    }
    private Node stack = null;
    private Node bottom;
    private Node previousBottom;
    private void getBottom() {
        Node current = stack;
        while (current.next != null) current = current.next;
        bottom = current;
        Node another = stack;
        while (another.next.next != null) another = another.next;
        previousBottom = another;
    }
    @Override
    public void push(E element) {
        if (stack == null) stack = new Node(element);
        else {
            Node currentNode = stack;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.setNext(new Node(element));
        }
    }

    @Override
    public E pop() {
        if (stack == null) return null;
        getBottom();
        E element = bottom.getElement();
        previousBottom.setNext(null);
        return element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (stack == null) return null;
        getBottom();
        return bottom.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
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
        };
        return iterator;
    }
}
