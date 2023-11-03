package hw6_21000699_dangngocquan.exercise003;

import hw6_21000699_dangngocquan.exercise003.sort.*;

public class TimeSort {
    public static <T extends Comparable<T>> long msBubbleSort(T[] array) {
        long start = System.currentTimeMillis();
        BubbleSort.sort(array);
        return System.currentTimeMillis() - start;
    }

    public static <T extends Comparable<T>> long msSelectionSort(T[] array) {
        long start = System.currentTimeMillis();
        SelectionSort.sort(array);
        return System.currentTimeMillis() - start;
    }

    public static <T extends Comparable<T>> long msInsertionSort(T[] array) {
        long start = System.currentTimeMillis();
        InsertionSort.sort(array);
        return System.currentTimeMillis() - start;
    }

    public static <T extends Comparable<T>> long msQuickSort(T[] array) {
        long start = System.currentTimeMillis();
        QuickSort.sort(array);
        return System.currentTimeMillis() - start;
    }

    public static <T extends Comparable<T>> long msMergeSort(T[] array) {
        long start = System.currentTimeMillis();
        MergeSort.sort(array);
        return System.currentTimeMillis() - start;
    }

    public static <T extends Comparable<T>> long msHeapSort(T[] array) {
        long start = System.currentTimeMillis();
        HeapSort.sort(array);
        return System.currentTimeMillis() - start;
    }
}
