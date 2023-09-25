package hw3_21000699_dangngocquan.exercise002;

import java.util.Arrays;
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
            enlarge();
        }
        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return array[i];
        }
    }

    @Override
    public T set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array[i] = data;
            return data;
        }
    }

    @Override
    public void remove(T data) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            for (int i = index+1; i < n; i++) {
                array[i-1] = array[i];
            }
            n--;
        }
    }

    @Override
    public boolean isContain(T data) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }
        return index > -1;
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
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return array[currentIndex++];
                } else {
                    return null;
                }
            }
        };
    }

    private void enlarge() {
        array = Arrays.copyOf(array, array.length * 2);
    }
}
