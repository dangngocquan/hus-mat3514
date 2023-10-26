package hw4_21000689_nguyenxuanloi.exercises.ex4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private final int DEFAULT_SIZE = 100;

    public ArrayQueue() {
        n = DEFAULT_SIZE;
        queue = (E[]) new Object[DEFAULT_SIZE];
    }
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (count == n) {
            throw new IllegalStateException("Queue is full.");
        } else {
            queue[(top + count) % n] = element;
            count++;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;


        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
