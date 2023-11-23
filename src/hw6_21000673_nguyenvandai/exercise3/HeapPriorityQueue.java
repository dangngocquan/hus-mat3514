package hw6_21000673_nguyenvandai.exercise3;

public class HeapPriorityQueue {
    private int[] heap;
    private int size;

    public HeapPriorityQueue(int capacity) {
        this.heap = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(int item) {
        if (size == heap.length) {
            return;
        }
        heap[size] = item;
        size++;
        upHeap(size - 1);
    }

    private void upHeap(int index) {
        int parentIndex = (index - 1) / 2;
        int itemToInsert = heap[index];
        while (index > 0 && itemToInsert < heap[parentIndex]) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        heap[index] = itemToInsert;
    }

    private void downHeap(int index) {
        int childIndex = 2 * index + 1;
        int itemToMoveDown = heap[index];
        while (childIndex < size) {
            if (childIndex + 1 < size && heap[childIndex + 1] < heap[childIndex]) {
                childIndex++;
            }
            if (itemToMoveDown <= heap[childIndex]) {
                break;
            }
            heap[index] = heap[childIndex];
            index = childIndex;
            childIndex = 2 * index + 1;
        }
        heap[index] = itemToMoveDown;
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is Empty");
        }
        int minItem = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downHeap(0);
        return minItem;
    }
}
