package hw4_22001273_nguyenhoangminh.excercise2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    public static final int DEFAULT_CAPACITY = 1000;
    public int capacity;
    private int size = 0;

    // Default Constructor
    public ArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Constructor with given capacity
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    public E get(int i) { return stack[i]; }

    @Override
    public void push(E element) {
        stack[size] = element;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E temp = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return temp;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return stack[size - 1];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    public class ArrayIterator implements Iterator<E> {
        int idx = 0;
        E current = stack[idx];
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            idx++;
            current = stack[idx];
            return current;
        }
    }

    @Override
    public String toString() {
        StringBuilder stack = new StringBuilder();
        for (E e : this.stack) {
            if (e != null) {
                stack.append(" | ");
                stack.append(e);
            }
        }
        return stack.toString();
    }
}
