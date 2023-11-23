package hw6_21000693_ledinhquangminh.Combo4Advanced;


import java.util.Arrays;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= array.length) {
            // Handle array resizing if necessary
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].key.compareTo(array[minIndex].key) < 0) {
                minIndex = i;
            }
        }

        Entry<K, E> minEntry = array[minIndex];
        // Remove the minEntry and fill the gap
        for (int i = minIndex; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        array[n - 1] = null;
        n--;

        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].key.compareTo(array[minIndex].key) < 0) {
                minIndex = i;
            }
        }
        return array[minIndex];
    }
}

