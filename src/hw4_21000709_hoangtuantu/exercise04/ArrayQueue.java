package hw4_21000709_hoangtuantu.exercise04;

import java.util.Iterator;

public class ArrayQueue<E> implements  Queue<E> {

    private final E[] queue;
    private int capacity = 100;
    private int top = 0;
    private int size = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        queue = (E[]) new Object[capacity];
    }

    public void enqueue(E element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        queue[(top + size) % capacity] = element;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        E data = queue[top];
        top = (top + 1) % capacity;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        E[] temp = (E[]) new Object[size];
        System.arraycopy(queue, 0, temp, 0, size);
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;
        private E[] data = queue;

        @Override
        public boolean hasNext() {
            return num < size;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % capacity];
            num++;
            return data;
        }
    }

    public String toString(){
        if (isEmpty()){
            return "";
        }StringBuilder result = new StringBuilder();
        int current = top;
        for (int i = 0; i < size; i++) {
            result.append(queue[current]).append(" ");
            current = (current + 1) % capacity;
        }

        return result.toString();
    }
}
