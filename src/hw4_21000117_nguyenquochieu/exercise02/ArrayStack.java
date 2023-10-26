package hw4_21000117_nguyenquochieu.exercise02;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E>{
    private E[] array;
    private static final int CAPACITY = 1000;
    private int index = -1;

    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public ArrayStack() {
        this(CAPACITY);
    }
    public int size() {
        return (index + 1);
    }
    private void enlarge() {
        E[] newData = (E[]) new Object[size() + CAPACITY];
        System.arraycopy(array, 0, newData, 0, size());
    }
    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == array.length) enlarge();
        array[++index] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E result = array[index];
        array[index] = null;
        index --;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return array[index];
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int currentIndex = size() - 1;
            @Override
            public boolean hasNext() {
                return currentIndex > 0;
            }

            @Override
            public E next() {
                return array[currentIndex--];
            }
        };
        return iterator;
    }
}
