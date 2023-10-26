package hw4_21000506_nguyenthithanhhuong.ex02;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E data;
        Node next;
    }

    private Node top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

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
        Node node = new Node();
        node.data = element;
        node.next = top;
        top = node;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E result = top.data;
        top = top.next;
        size--;
        return result;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
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
