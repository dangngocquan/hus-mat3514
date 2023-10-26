package hw4_21000709_hoangtuantu.exercise02;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{
    private E[] container = (E[]) new Object[26];
    private int size = 0;

    @Override
    public void push(E element) {
        if (size == container.length - 5){
            expand();
        }
        container[size] = element;
        size++;
    }

    private void expand(){
        E[] result = (E[]) new Object[size * 10];
        System.arraycopy(container, 0, result, 0, size);
        container = result;
    }

    @Override
    public E pop() {
        if (size == 0){
            throw new NullPointerException();
        }
        size --;
        E data = container[size];
        container[size] = (E) new Object();
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (size == 0){
            throw new NullPointerException();
        }
        return container[size - 1];
    }

    @Override
    public String toString() {
        if (size == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++){
            result.append(container[i]);
            if (i < size - 1){
                result.append(", ");
            }
        }
        return result.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            index++;
            return container[index - 1];
        }
    }


}
