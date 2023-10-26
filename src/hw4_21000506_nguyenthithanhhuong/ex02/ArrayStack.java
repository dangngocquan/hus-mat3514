package hw4_21000506_nguyenthithanhhuong.ex02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 100;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E element) {
        if (data.length == top+1) {
            enlarge();
        }
        data[++top] = element;
    }

    private void enlarge() {
        E[] tempData = (E[]) new Object[data.length*2];
        for (int i = 0; i < data.length; i++) {
            tempData[i] = data[i];
        }
        data = tempData;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E result = data[top];
        data[top] = null;
        top--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int currentIndex = top;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            return data[currentIndex--];
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