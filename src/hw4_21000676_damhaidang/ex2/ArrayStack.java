package hw4_21000676_damhaidang.ex2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E>{
    private final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E element) throws IllegalArgumentException{
        if (size() == data.length)
            throw new IllegalArgumentException("Stack is full");
        top++;
        data[top] = element;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E result = data[top];
        data[top] = null;
        top--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int curr = top;
            @Override
            public boolean hasNext() {
                return curr >= 0;
            }

            @Override
            public E next() {
                E result = data[curr];
                curr--;
                return result;
            }
        };

    }
}
