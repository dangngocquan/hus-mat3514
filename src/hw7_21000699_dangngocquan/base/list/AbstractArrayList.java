package hw7_21000699_dangngocquan.base.list;

import java.util.Iterator;

public abstract class AbstractArrayList<E extends Comparable<E>> extends AbstractList<E> {
    public static final int DEFAULT_CAPACITY = 4;
    protected E[] data;
    protected int size;

    public AbstractArrayList() {
        data = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public AbstractArrayList(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public E remove(int index) {
        E value = get(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].compareTo(value) == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    protected class ArrayListIterator implements Iterator<E> {
        protected int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return data[currentIndex++];
        }
    }

    protected void enlarge() {
        E[] newData = (E[]) new Comparable[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
