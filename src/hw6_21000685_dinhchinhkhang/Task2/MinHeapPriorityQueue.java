package hw6_21000685_dinhchinhkhang.Task2;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.Task1.SortedArrayPrimaryQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPrimaryQueue<K, E> {
    ArrEntry<K, E>[] heapPQ;
    int defaultSize = 1000;
    int n = 0;

    public MinHeapPriorityQueue() {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }
    public void insertToHeap(Entry<K, E> entry) {
        if (n == heapPQ.length) {
            int wide = heapPQ.length * 2;
            heapPQ = (ArrEntry<K, E>[]) new ArrEntry[wide];
        }
        heapPQ[n] = (ArrEntry<K, E>) entry;
        n++;
        upHeap();
    }
    public void insert(K k, E e) {
        insertToHeap(new ArrEntry<>(k, e));
    }
    protected void upHeap() {
        int childIdx = n - 1;
        while(childIdx > 0) {
            int parentIdx = (childIdx)/2;
            if(heapPQ[childIdx].getKey().compareTo(heapPQ[parentIdx].getKey()) >= 0) {
                break;
            }
            ArrEntry<K, E> temp = heapPQ[childIdx];
            heapPQ[childIdx] = heapPQ[parentIdx];
            heapPQ[parentIdx] = temp;
            childIdx = parentIdx;
        }
    }
    protected void downHeap() {
        int parentIdx = 0;
        ArrEntry<K, E> removeIdx;

        while(true) {
            int leftChildIdx = (2 * parentIdx) - 1;
            int rightChildIdx = (2 * parentIdx) + 1;
            int minIdx = parentIdx;

            if (leftChildIdx < n && heapPQ[leftChildIdx].getKey().compareTo(heapPQ[minIdx].getKey()) < 0) {
                minIdx = leftChildIdx;
            }
            if(rightChildIdx < n && heapPQ[rightChildIdx].getKey().compareTo(heapPQ[minIdx].getKey()) < 0) {
                minIdx = rightChildIdx;
            }
            if(minIdx == parentIdx) {
                break;
            }

            ArrEntry<K, E> temp = heapPQ[parentIdx];
            heapPQ[parentIdx] = heapPQ[minIdx];
            heapPQ[minIdx] = temp;
            parentIdx = minIdx;
        }
    }
    public Entry<K, E> removeMin() {
        if(isEmpty()) {
            return null;
        }
        int removeIdx = 0;
        Entry<K, E> remove = heapPQ[removeIdx];
        heapPQ[removeIdx] = heapPQ[n-1];
        n--;
        downHeap();
        return remove;
    }
    public Entry<K, E> min() {
        return heapPQ[0];
    }
    public boolean isEmpty() {
        return n == 0;
    }
}
