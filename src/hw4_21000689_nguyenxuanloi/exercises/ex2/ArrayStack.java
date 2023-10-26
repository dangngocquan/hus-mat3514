package hw4_21000689_nguyenxuanloi.exercises.ex2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] elements;
    private final int DEFAULT_SIZE = 10;
    private int t = -1;

    class StackIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public E next() {
            E data = elements[index++];
            return data;
        }
    }

    public ArrayStack() {
        this.elements = (E[]) new Object[DEFAULT_SIZE];
    }

    public ArrayStack(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == elements.length) {
            throw new IllegalStateException("Stack is full.");
        }
        elements[++t] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            E result = top();
            elements[t] = null;
            t--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public E top() {
        return isEmpty() ? null : elements[t];
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    void allocateMore() {
        E[] temp = (E[]) new Object[2 * elements.length];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }
}
