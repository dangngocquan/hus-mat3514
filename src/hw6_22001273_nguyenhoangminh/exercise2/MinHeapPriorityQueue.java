package hw6_22001273_nguyenhoangminh.exercise2;

import hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue.SortedArrayPriorityQueue;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    ArrayEntry<K, E>[] heapPQ;

    private int size = 0;

    public MinHeapPriorityQueue(int capacity) {
        heapPQ = new ArrayEntry[capacity];
    }

    public MinHeapPriorityQueue() {
        heapPQ = new ArrayEntry[1000];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    protected void upHeap() {
        int i = size;
        while (i > 1 && heapPQ[i / 2].getKey().compareTo(heapPQ[i].getKey()) > 0) {
            ArrayEntry<K, E> temp = heapPQ[i / 2];
            heapPQ[i / 2] = heapPQ[i];
            heapPQ[i] = temp;
            i = i / 2;
        }
    }

    protected void downHeap() {
        int i = 1;      // First element of the array
        while (i < size) {
            if (2 * i + 1 < size) {
                if (heapPQ[2 * i].getKey().compareTo(heapPQ[i].getKey()) > 0 && heapPQ[2 * i + 1].getKey().compareTo(heapPQ[i].getKey()) > 0) {
                    return;
                }
                else {
                    int j;
                    if (heapPQ[2 * i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) > 0) {
                        j = 2 * i + 1;
                    } else {
                        j = 2 * i;
                    }
                    ArrayEntry<K, E> temp = heapPQ[i];
                    heapPQ[i] = heapPQ[j];
                    heapPQ[j] = temp;
                    i = j;
                }
            } else {
                if (2 * i < size) {
                    if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) > 0) {
                        ArrayEntry<K, E> temp = heapPQ[i];
                        heapPQ[i] = heapPQ[2 * i];
                        heapPQ[2 * i] = temp;
                    }
                    i = 2 * i;
                } else return;
            }
        }

        return;
    }

    public void insert(K key, E value) {
        ArrayEntry<K, E> entry = new ArrayEntry(key, value);
        size++;
        heapPQ[size] = entry;
        upHeap();
    }

    public ArrayEntry<K, E> removeMin() {
        if (isEmpty()) return null;
        ArrayEntry<K, E> temp = heapPQ[1];
        heapPQ[1] = heapPQ[size];
        heapPQ[size] = temp;
        size--;
        downHeap();
        return temp;
    }

    public ArrayEntry<K, E> removeMax() {
        if (isEmpty()) return null;
        ArrayEntry<K, E> temp = heapPQ[size];
        heapPQ[size] = null;
        size--;
        return temp;
    }

    public ArrayEntry<K, E> max() { return heapPQ[size]; }

    public ArrayEntry<K, E> min() {
        return heapPQ[1];
    }

    @Override
    public String toString() {
        return Arrays.toString(heapPQ);
    }
}
