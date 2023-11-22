package hw6_21000709_hoangtuantu.excercise02;

import hw6_21000709_hoangtuantu.excercise01.*;


public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private final ArrEntry<K, E>[] heap;

    public MinHeapPriorityQueue(E[] heap) {
        this.heap = new ArrEntry[heap.length];
        for (int i = 0; i < heap.length; i++){
            this.heap[i] = new ArrEntry<>((K)heap[i], heap[i]);
        }
        size = heap.length;
        upHeap(size - 1);
    }

    public MinHeapPriorityQueue(int capacity) {
        super(capacity);
        heap = new ArrEntry[capacity];
    }

    protected int parent(int index) {
        if (index % 2 == 0) {
            return (index - 2) / 2;
        }
        return (index - 1) / 2;
    }

    protected int left(int index) {
        return 2 * index + 1;
    }

    protected int right(int index) {
        return 2 * index + 2;
    }

    protected void swap(int i, int j) {
        ArrEntry<K, E> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Implement upHeap to maintain Min-Heap property
    public void upHeap(int index) {
        while (index > 0 && heap[parent(index)].getKey().compareTo(heap[index].getKey()) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void downHeap(int index) {
        swap(index, size -1);
        heap[size - 1] = null;
        size--;
        int min, left, right;
        while (true){
            min = index;
            left = left(index);
            right = right(index);
            if (left < size && heap[left].getKey().compareTo(heap[min].getKey()) < 0){
                min = left;
            }

            if (right < size && heap[right].getKey().compareTo(heap[min].getKey()) < 0){
                min = right;
            }

            if (index != min){
                swap(index, min);
                index = min;
            }else{
                break;
            }
        }
        heap[min] = null;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> entry = new ArrEntry<>(k, e);
        heap[size] = entry;
        size++;
        upHeap(size() - 1);
    }

    public void printInOrder() {
        printInOrder(0);
    }

    private void printInOrder(int index) {
        if (index < size()) {
            printInOrder(left(index));
            System.out.println("Key: " + heap[index].getKey() + ", Value: " + heap[index].getValue());
            printInOrder(right(index));
        }
    }
}
