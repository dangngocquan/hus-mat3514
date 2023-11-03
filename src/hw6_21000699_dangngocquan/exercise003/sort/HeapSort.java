package hw6_21000699_dangngocquan.exercise003.sort;

import hw6_21000699_dangngocquan.base.MinHeapPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        PriorityQueueInterface<T, T> heapQueue = new MinHeapPriorityQueue<>();
        for (T element : array) heapQueue.insert(element, element);
        int i = 0;
        while (!heapQueue.isEmpty()) array[i++] = heapQueue.removeMin().getKey();
    }
}
