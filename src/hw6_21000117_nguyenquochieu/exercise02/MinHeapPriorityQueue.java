package hw6_21000117_nguyenquochieu.exercise02;

import hw6_21000117_nguyenquochieu.exercise01.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue {
    private int compare(int i, int j) {
        return ((K) array[i].getKey()).compareTo((K) array[j].getKey());
    }

    public ArrayEntry getRoot() {
        return array[0];
    }
    public E getRootValue() {
        return (E) array[0].getValue();
    }
    @Override
    public int size() {
        return super.size();
    }

    public void upHeap() {
        int index = n - 1;
        while (index > 0 && compare(index / 2, index) > 0) {
            ArrayEntry temp = array[index / 2];
            array[index / 2] = array[index];
            array[index] = temp;
            index /= 2;
        }
    }

    public void downHeap() {
        int index = 0;
        int bound = n - 1;
        int step = 0;
        while (index < bound && step < bound) {
            if (2 * index + 2 < bound) {
                if (!(compare(index, 2 * index + 1) < 0 && compare(index, 2 * index + 2) < 0)) {
                    int j = compare(2 * index + 1, 2 * index + 2) > 0 ? 2 * index + 2 : 2 * index + 1;
                    ArrayEntry temp = array[index];
                    array[index] = array[j];
                    array[j] = temp;
                    index = j;
                }
            } else {
                if (2 * index + 1 < bound) {
                    if (compare(index, 2 * index + 1) > 0) {
                        ArrayEntry temp = array[index];
                        array[index] = array[2 * index + 1];
                        array[2 * index + 1] = temp;
                    }
                }
            }
            step++;
        }
    }
}
