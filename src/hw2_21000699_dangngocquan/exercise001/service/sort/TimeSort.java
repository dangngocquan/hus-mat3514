package hw2_21000699_dangngocquan.exercise001.service.sort;

import hw2_21000699_dangngocquan.exercise001.service.sort.BubbleSort;

public class TimeSort {
    public static void bubbleSort(int[] a) {
        long time = BubbleSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static void selectionSort(int[] a) {
        long time = SelectionSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static void insertionSort(int[] a) {
        long time = InsertionSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static void mergeSort(int[] a) {
        long time = MergeSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static void quickSort(int[] a) {
        long time = QuickSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }
}
