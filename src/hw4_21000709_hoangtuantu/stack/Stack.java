package hw4_21000709_hoangtuantu.stack;

public class Stack {
    private Object[] container = new Object[26];
    private int size = 0;

    public void push(Object element) {
        if (size == container.length - 5) {
            expand();
        }
        container[size] = element;
        size++;
    }

    private void expand() {
        Object[] result = new Object[size * 10];
        System.arraycopy(container, 0, result, 0, size);
        container = result;
    }

    public Object pop() {
        if (size == 0) {
            throw new NullPointerException();
        }
        size--;
        Object data = container[size];
        container[size] = null; // Set the element to null
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object top() {
        return container[size - 1];
    }

    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(container[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public int size() {
        return size;
    }
}
