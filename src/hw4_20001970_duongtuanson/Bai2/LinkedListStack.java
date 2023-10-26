package hw4_20001970_duongtuanson.Bai2;
import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack = null;

    @Override
    public void push(E data) {
        Node newNode = new Node();
        newNode.element = data;
        newNode.next = this.stack;
        this.stack = newNode;
    }

    @Override
    public E pop() {
        if (this.stack == null) {
            return null;
        }
        E temp = this.stack.element;
        this.stack = this.stack.next;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return this.stack == null;
    }

    @Override
    public E top() {
        if (this.stack == null) {
            return null;
        }
        return this.stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node current = stack;

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public E next() {
            E temp = this.current.element;
            this.current = this.current.next;
            return temp;
        }
    }
}
