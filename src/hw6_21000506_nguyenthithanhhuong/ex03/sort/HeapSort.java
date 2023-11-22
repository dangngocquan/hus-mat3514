package hw6_21000506_nguyenthithanhhuong.ex03.sort;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;
import hw6_21000506_nguyenthithanhhuong.ex02.MinHeapPriorityQueue;

public class HeapSort {
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        PriorityQueueInterface<T, T> heap = new MinHeapPriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i], array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.removeMin().getKey();
        }
        return array;
    }

    public static <T extends Comparable<T>> long time(T[] array) {
        long start =  System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
