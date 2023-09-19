package hw2_21000699_dangngocquan.exercise002.service.sort;

import java.util.Arrays;

public class QuickSort {
    private static int countCompare;
    private static int countSwap;

    // sort and return data [countCompare, countSwap]
    public static <T extends Comparable<T>> int[] sort(T[] a) {
        countCompare = 0;
        countSwap = 0;
        System.out.printf("%-30s: %s\n",
                "Initial array",
                Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        return new int[] {countCompare, countSwap};
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
            countCompare++;
            if (a[i].compareTo(pivotValue) < 0) {
                pivotIndex++;
                T temp = a[i];
                a[i] = a[pivotIndex];
                a[pivotIndex] = temp;
                countSwap++;
            }
        }
        T temp = a[left];
        a[left] = a[pivotIndex];
        a[pivotIndex] = temp;
        countSwap++;

        System.out.printf("%-30s: %s\n",
                String.format("After partition a[%d, %d]", left, right),
                Arrays.toString(a));

        return pivotIndex;
    }

    // sort and return time in milliseconds
    public static <T extends Comparable<T>> long timeSort(T[] a) {
        long start = System.currentTimeMillis();
        quickSort0(a, 0, a.length-1);
        return System.currentTimeMillis() - start;
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void quickSort0(T[] a, int left, int right) {
        if (left < right) {
            int pivotIndex = partition0(a, left, right);
            quickSort0(a, left, pivotIndex-1);
            quickSort0(a, pivotIndex+1, right);
        }
    }

    private static <T extends Comparable<T>> int partition0(T[] a, int left, int right) {
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
