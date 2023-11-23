package hw6_21000685_dinhchinhkhang.Task1;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.PriorityQueueInterface;

public class SortedArrayPrimaryQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    public static class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        public String toString() {
            return "(key: " + key + ", value: " + element + ")";
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;
    public SortedArrayPrimaryQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
        n = 0;
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
            int wide = n * 2;
            array =  (ArrEntry<K, E>[]) new ArrEntry[wide];
        }
        int idx = n;
        while(idx > 0 && entry.getKey().compareTo(array[idx - 1].getKey()) < 0) {
            array[idx] = array[idx - 1];
            idx--;
        }
        array[idx] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if(isEmpty()) {
            return null;
        }
        int removeIdx = 0;
        Entry<K, E> remove = array[removeIdx];
        for(int i = 0; i < n; i++) {
            array[i] = array[i+1];
            if(i == n -1) {
                array[i] = null;
                n--;
                break;
            }
        }
        return remove;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            return null;
        }
        int minKey = 0;
        return array[minKey];
    }
}