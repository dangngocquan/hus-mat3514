package hw3_21000676_damhaidang.ex2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private final int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (n == array.length - 1) {
            enlarge();
        }
        array[n++] = data;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, T data) {
        array[index] = data;
    }

    @Override
    public void remove(T data) {
        int count = 0;
        for (int i = 0; i < array.length - count; i++) {
            if (array[i] == data) {
                count++;
            }
            array[i] = array[i + count];
        }
        n -= count;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean isContain(T data) {
        for (T t : array) {
            if (t == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int counter = 0;

            public boolean hasNext() {
                return counter < size();
            }

            public T next() {
                return get(counter++);
            }
        };
    }

    public void enlarge() {
        T[] copy = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, copy, 0, array.length);
        array = copy;
    }
}
