package hw4_22001273_nguyenhoangminh.excercise4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private final int DEFAULT_CAPACITY = 1000;
    private int capacity;
    private int size = 0;
    private int first = 0;

    // Default Constructors
    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Constructor with given capacity
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
    }

    public int getLength() { return queue.length; }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (size == queue.length) enlargeQueue();
        int available = (first + size) % queue.length;
        queue[available] = element;
        size++;
    }

    public void enlargeQueue() {
        E[] largeQueue = (E[]) new Object[queue.length * 2+1];
        for (int i = 0; i < size; ++i) {
            largeQueue[i] = queue[(first + i) % queue.length];
        }
        first = 0;
        queue = largeQueue;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return queue[first];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E temp = queue[first];
        queue[first] = null;
        first = (first + 1) % queue.length;
        size--;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    public class ArrayQueueIterator implements Iterator<E> {
        int idx = 0;
        E current = queue[first];

        @Override
        public boolean hasNext() {
            return idx < size;
        }

        @Override
        public E next() {
            current = queue[(first + idx) % queue.length];
            idx++;
            return current;
        }
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        for (E e : this.queue) {
            if (e != null) {
                queue.append(e);
                queue.append(" | ");
            }
        }
        return queue.toString();
    }
}
