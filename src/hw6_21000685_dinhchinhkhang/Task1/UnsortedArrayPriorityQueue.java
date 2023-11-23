package hw6_21000685_dinhchinhkhang.Task1;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.PriorityQueueInterface;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected static class ArrEntry<K, E> implements Entry<K, E> {
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
    public UnsortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
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
        array[n++] = (ArrEntry<K, E>) entry;
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
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if(array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                minIdx = i;
            }
        }
        Entry<K, E> remove = array[minIdx];
        array[minIdx] = array[n-1];
        array[n-1] = null;
        n--;
        return remove;
    }

    @Override
    public  Entry<K, E> min() {
        if(isEmpty()){
            return null;
        }
        Entry<K, E> minKey = array[0];
        for(int i =1; i < n; i++) {
            if (array[i].getKey().compareTo(minKey.getKey()) < 0) {
                minKey = array[i];
            }
        }
        return minKey;
    }
}
