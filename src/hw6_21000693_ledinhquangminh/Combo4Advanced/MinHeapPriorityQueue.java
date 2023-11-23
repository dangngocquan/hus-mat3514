package hw6_21000693_ledinhquangminh.Combo4Advanced;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    public MinHeapPriorityQueue() {
        super();
    }

    // Override the insert method to maintain the Min Heap property
    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= array.length) {
            // Handle array resizing if necessary
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[n] = (ArrEntry<K, E>) entry;
        upHeap(n);
        n++;
    }

    // Override the removeMin method to maintain the Min Heap property
    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        Entry<K, E> minEntry = array[0];
        array[0] = array[n - 1];
        array[n - 1] = null;
        n--;
        downHeap(0);

        return minEntry;
    }

    // Helper method to maintain the Min Heap property after insertion
    private void upHeap(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[index].getKey().compareTo(array[parentIndex].getKey()) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Helper method to maintain the Min Heap property after removal
    private void downHeap(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < n && array[leftChildIndex].getKey().compareTo(array[smallest].getKey()) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < n && array[rightChildIndex].getKey().compareTo(array[smallest].getKey()) < 0) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            downHeap(smallest);
        }
    }

    // Helper method to swap two elements in the array
    private void swap(int i, int j) {
        ArrEntry<K, E> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
