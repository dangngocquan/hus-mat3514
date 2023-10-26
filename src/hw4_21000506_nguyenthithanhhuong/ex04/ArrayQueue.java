package hw4_21000506_nguyenthithanhhuong.ex04;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] data;
    private int size = 0;
    private int first = 0;
    private int CAPACITY = 100;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (size == data.length) enlarge();
        data[(first + size) % data.length] = element;
        size++;
    }

    private void enlarge() {
        E[] newData = (E[]) new Object[2*data.length];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(first + i) % data.length];
        }
        data = newData;
        first = 0;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[first];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E result = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            E element = data[(currentIndex + first) % data.length];
            currentIndex++;
            return element;
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
