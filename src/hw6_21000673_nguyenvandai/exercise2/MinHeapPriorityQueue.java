package hw6_21000673_nguyenvandai.exercise2;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private ArrEntry<K, E>[] heapPQ;

    public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    protected void upHeap() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        ArrEntry<K, E> entryToInsert = heapPQ[childIndex];
        while (childIndex > 0 && entryToInsert.getKey().compareTo(heapPQ[parentIndex].getKey()) < 0) {
            heapPQ[childIndex] = heapPQ[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapPQ[childIndex] = entryToInsert;
    }

    protected void downHeap() {
        int parentIndex = 0;
        ArrEntry<K, E> entryToMoveDown = heapPQ[parentIndex];
        while (parentIndex < size / 2) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            int smallerChildIndex;
            if (rightChildIndex < size && heapPQ[rightChildIndex].getKey().compareTo(heapPQ[leftChildIndex].getKey()) < 0) {
                smallerChildIndex = rightChildIndex;
            } else {
                smallerChildIndex = leftChildIndex;
            }
            if (entryToMoveDown.getKey().compareTo(heapPQ[smallerChildIndex].getKey()) <= 0) {
                break;
            }
            heapPQ[parentIndex] = heapPQ[smallerChildIndex];
            parentIndex = smallerChildIndex;
        }
        heapPQ[parentIndex] = entryToMoveDown;
    }

    public void insert(K key, E element) {
        ArrEntry<K, E> newEntry = new ArrEntry<>(key, element);
        if (size == heapPQ.length) {
            // Heap is full, need to resize the array or handle accordingly
            return;
        }

        heapPQ[size] = newEntry;
        size++;

        upHeap();
    }

    public E removeMin() {
        if (isEmpty()) {
            return null;
        }
        ArrEntry<K, E> minEntry = heapPQ[0];
        heapPQ[0] = heapPQ[size - 1];
        size--;

        downHeap();

        return minEntry.getElement();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

