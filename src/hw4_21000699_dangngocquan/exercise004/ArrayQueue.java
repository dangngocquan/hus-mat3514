package hw4_21000699_dangngocquan.exercise004;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int firstIndex;
    private int size;

    public ArrayQueue() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(E element) {
        if (size == data.length) enlarge();
        data[(firstIndex + size) % data.length] = element;
        size++;
    }

    @Override
    public E dequeue() {
        E element = data[firstIndex];
        firstIndex = (firstIndex + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public E first() {
        if (size == 0) return null;
        return data[firstIndex];
    }

    @Override
    public E last() {
        if (size == 0) return null;
        return data[(firstIndex + size - 1) % data.length];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void enlarge() {
        /*

        data    [.] [.] [.] [.] [f] [.] [.]
                 .   .   .   .   .   .   .
                 .   .   .   .       .   .   .
                 .   .   .   .           .   .   .
                 .   .   .   .               .   .   .
                 .   .   .   .                   .   .   .
                 .   .   .   .                       .   .   .
                 .   .   .   .                           .   .   .
                 .   .   .   .                               .   .   .
        newData [.] [.] [.] [.] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [f] [.] [.]

        */

        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < firstIndex; i++) newData[i] = data[i];
        for (int i = firstIndex; i < data.length; i++) newData[i+data.length] = data[i];
        firstIndex += data.length;
        data = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            E element = data[(currentIndex + firstIndex) % data.length];
            currentIndex++;
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }
        if (sb.length() > 1) sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
