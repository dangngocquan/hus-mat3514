package hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue;

import hw6_22001273_nguyenhoangminh.exercise1.Entry;
import hw6_22001273_nguyenhoangminh.exercise1.PriorityQueueInterface;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class ArrayEntry<K, E> implements Entry<K, E> {
        K key;
        E value;

        public ArrayEntry(K key, E value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key.toString() + "," + value.toString() + ")";
        }
    }
    ArrayEntry<K, E>[] arrayEntries;
    int size = 0;
    int DEFAULT_CAPACITY = 1000;

    public UnsortedArrayPriorityQueue(int capacity) {
        arrayEntries = new ArrayEntry[capacity];
    }

    public UnsortedArrayPriorityQueue() {
        arrayEntries = new ArrayEntry[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        arrayEntries[size] =(ArrayEntry<K, E>) entry;
        size++;
    }

    @Override
    public void insert(K key, E value) {
        arrayEntries[size] = new ArrayEntry<>(key, value);
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        int minKey = 0;
        for (int i = 1; i < size; i++) {
            if (arrayEntries[i].key.compareTo(arrayEntries[minKey].key) < 0) {
                minKey = i;
            }
        }

        ArrayEntry<K, E> temp = arrayEntries[minKey];

        for (int i = minKey; i < size - 1; i++) {
            arrayEntries[i] = arrayEntries[i + 1];
        }
        size--;
        return (ArrayEntry<K, E>)  arrayEntries[minKey];
    }

    @Override
    public Entry<K, E> min() {
        int minKey = 0;
        for (int i = 1; i < size; i++) {
            if (arrayEntries[i].key.compareTo(arrayEntries[minKey].key) < 0) {
                minKey = i;
            }
        }

        return (ArrayEntry<K, E>) arrayEntries[minKey];
    }

    @Override
    public String toString() {
        StringBuilder pq = new StringBuilder();
        for (int i = 0; i < size; i++) {
            pq.append(arrayEntries[i].toString());
        }

        return pq.toString();
    }
}
