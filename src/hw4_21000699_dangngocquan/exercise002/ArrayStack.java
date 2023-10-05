package hw4_21000699_dangngocquan.exercise002;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public ArrayStack() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E element) {
        if (size == data.length) enlarge();
        data[size++] = element;
    }

    @Override
    public E pop() {
        if (size == 0) return null;
        return data[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (size == 0) return null;
        return data[size-1];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyStackIterator();
    }

    class MyStackIterator implements Iterator<E> {
        private int currentIndex = size-1;

        @Override
        public boolean hasNext() {
            return currentIndex > -1;
        }

        @Override
        public E next() {
            return data[currentIndex--];
        }
    }

    private void enlarge() {
        E[] newData = (E[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) newData[i] = data[i];
        data = newData;
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
