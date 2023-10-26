package hw4_21000676_damhaidang.ex2;

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
        newNode.next = stack;
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

    public E peek() {
        // check for empty stack
        if (!isEmpty()) {
            return stack.element;
        }
        else {
            System.out.println("Stack is empty");
            return null;
        }
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
