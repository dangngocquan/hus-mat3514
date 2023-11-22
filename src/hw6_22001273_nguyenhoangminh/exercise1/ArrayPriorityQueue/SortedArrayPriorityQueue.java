package hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue;

import hw6_22001273_nguyenhoangminh.exercise1.Entry;
import hw6_22001273_nguyenhoangminh.exercise1.PriorityQueueInterface;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    public class ArrayEntry<K, E> implements Entry<K, E> {
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

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key.toString() + "," + value.toString() + ")";
        }
    }

    ArrayEntry<K, E>[] arrayEntries;
    int size = 0;
    int DEFAULT_CAPACITY = 1000;

    public SortedArrayPriorityQueue(int capacity) {
        arrayEntries = new ArrayEntry[capacity];
    }

    public SortedArrayPriorityQueue() {
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

    public Entry<K, E> get(int i) {
        return arrayEntries[i];
    }

    @Override
    public void insert(Entry<K, E> entry) {
        int idx = 0;

        for (int i = size - 1; i >= 0; i--) {
            K entryKey = entry.getKey();
            K arrayKey = arrayEntries[i].getKey();
            if (entryKey.compareTo(arrayKey) < 0) {
                idx = i + 1;
                break;
            }
        }

        for (int i = size; i > idx; i--) {
            arrayEntries[i] = arrayEntries[i - 1];
        }

        arrayEntries[idx] = (ArrayEntry<K, E>) entry;
        size++;
    }

    @Override
    public void insert(K key, E value) {
        insert(new ArrayEntry<>(key, value));
    }

    @Override
    public Entry<K, E> removeMin() {
        ArrayEntry<K, E> temp = arrayEntries[size];
        arrayEntries[size] = null;
        size--;
        return temp;
    }

    @Override
    public Entry<K, E> min() {
        return arrayEntries[size - 1];
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
