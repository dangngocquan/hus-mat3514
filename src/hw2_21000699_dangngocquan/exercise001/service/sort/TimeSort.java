package hw2_21000699_dangngocquan.exercise001.service.sort;

import hw2_21000699_dangngocquan.exercise001.service.sort.BubbleSort;

public class TimeSort {
    public static long bubbleSort(int[] a) {
        return BubbleSort.timeSort(a);
    }

    public static long selectionSort(int[] a) {
        return SelectionSort.timeSort(a);
    }

    public static long insertionSort(int[] a) {
        return InsertionSort.timeSort(a);
    }

    public static long mergeSort(int[] a) {
        return MergeSort.timeSort(a);
    }

    public static long quickSort(int[] a) {
        return QuickSort.timeSort(a);
    }
}
