package hw3_22001273_nguyenhoangminh.excercise2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int size = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        array[size] = data;
        size++;
    }

    public T get(int i) {
//        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        return array[i];
    }

    public void set(int i, T data) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        array[i] = data;
    }

    public void remove(T data)  {
        for (int i = 0; i < size; ++i) {
            if (data.equals(array[i])) {
                for (int rmIdx = i; rmIdx < size; ++rmIdx) {
                    array[rmIdx] = array[rmIdx + 1];      // shift element to the left
                }
                size--;
                i--;        // start checking again from i
            }
        }
    }

    public boolean isContain(T data) {
        return getIndexOf(data) != -1;
    }

    public int getIndexOf(T data) {
        for (int i = 0; i < size; ++i) {
            if(data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int size() { return size; }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                str.append(array[i]);
                str.append(", ");
            } else {
                str.append(array[i]);
            }
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>(this);
    }

    class ArrayListIterator<T> implements Iterator<T> {
        T current;
        SimpleArrayList<T> list;

        int Idx = 0;

        public ArrayListIterator(SimpleArrayList<T> list) {
            this.list = list;
            current = list.get(Idx);
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current;
            Idx++;
            current = list.get(Idx);
            return data;
        }
    }
}
