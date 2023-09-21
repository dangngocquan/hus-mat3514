package hw2_21000699_dangngocquan.exercise003.services.sort;

import java.util.Arrays;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        quickSort(a, 0, a.length-1);
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(a, left, right);
            quickSort(a, left, pivotIndex-1);
            quickSort(a, pivotIndex+1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        T pivotValue = a[left];
        int pivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i].compareTo(pivotValue) < 0) {
                pivotIndex++;
                T temp = a[i];
                a[i] = a[pivotIndex];
                a[pivotIndex] = temp;
            }
        }
        T temp = a[left];
        a[left] = a[pivotIndex];
        a[pivotIndex] = temp;

        return pivotIndex;
    }
}
