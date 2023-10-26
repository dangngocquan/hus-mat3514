package hw4_21000117_nguyenquochieu.exercise04;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int CAPACITY = 100;
    public ArrayQueue() {
        n = CAPACITY;
        queue = (E[]) new Object[CAPACITY];
    }
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }
    private void enlarge() {
        E[] newQueue = (E[]) new Object[n + CAPACITY];
        System.arraycopy(queue, 0, newQueue, 0, n);
    }
    @Override
    public void enqueue(E element) {
        if (count == n) enlarge();
        queue[count++] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E result = queue[top];
        queue[top] = null;
        top ++;
        count--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int currentIndex = top;
            private int num = 0;
            @Override
            public boolean hasNext() {
                return num < count;
            }

            @Override
            public E next() {
                E data = queue[(currentIndex + num) % n];
                num ++;
                return data;
            }
        };
        return iterator;
    }
}
