package hw4_21000676_damhaidang.ex3;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
        public Node(E element) {
            this.element = element;
        }
    }

    private Node stack = null;

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (stack != null) {
            newNode.next = stack;
        }
        stack = newNode;
    }

    @Override
    public E pop() {
        if (stack == null) return null;
        Node temp = stack;
        stack = temp.next;
        return temp.element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node currentNode = stack;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E data = currentNode.element;
                currentNode = currentNode.next;
                return data;
            }
        };
    }


}
