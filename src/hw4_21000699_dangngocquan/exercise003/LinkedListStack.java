package hw4_21000699_dangngocquan.exercise003;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack = null;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;
        size++;
    }

    @Override
    public E pop() {
        E element = stack.element;
        if (stack != null) {
            stack = stack.next;
            size--;
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (stack == null) return null;
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyStackIterator();
    }

    class MyStackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E element = currentNode.element;
            currentNode = currentNode.next;
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            sb.insert(1, ", ").insert(1, iterator.next());
        }
        if (sb.length() > 1) sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
