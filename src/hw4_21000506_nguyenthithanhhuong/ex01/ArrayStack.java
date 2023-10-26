package hw4_21000506_nguyenthithanhhuong.ex01;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 100;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = element;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E result = data[t];
        data[t] = null;
        t--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                sb.append(data[i]).append(", ");}
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }
}
