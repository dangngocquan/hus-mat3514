package hw3_21000506_nguyenthithanhhuong.ex02;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (n == array.length) {
            T[] newArray;
            newArray = (T[]) new Object[array.length*2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public void set(int i , T data) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        int key = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                key = i;
                break;
            }
        }
        if (key > -1) {
            for (int j = key; j < n; j++) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        n--;
    }

    @Override
    public boolean isContain(T data) {
        int key = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                key = i;
                break;
            }
        }
        return key > -1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                T result = null;
                if(hasNext()) {
                    result = array[index++];
                }
                return result;
            }
        };
    }
}
