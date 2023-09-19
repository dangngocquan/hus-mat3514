package hw2_21000699_dangngocquan.exercise002.service.sort;

import java.util.Arrays;

public class MergeSort {
    private static int countCompare;
    private static int countSwap;

    // sort and return data [countCompare, countSwap]
    public static <T extends Comparable<T>> int[] sort(T[] a) {
        countCompare = 0;
        countSwap = 0;
        System.out.printf("%-30s: %s\n",
                "Initial array",
                Arrays.toString(a));
        mergeSort(a, 0, a.length-1);
        return new int[] {countCompare, countSwap};
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(a, left, mid);
            System.out.printf("%-30s: %s\n",
                    String.format("After sort a[%d, %d]", left, mid),
                    Arrays.toString(a));

            mergeSort(a, mid + 1, right);
            System.out.printf("%-30s: %s\n",
                    String.format("After sort a[%d, %d]", mid+1, right),
                    Arrays.toString(a));

            merge(a, left, mid, right);
            System.out.printf("%-30s: %s\n",
                    String.format("After merge a[%d, %d]", left, right),
                    Arrays.toString(a));
        }
    }

    // merge two sorted sub-array a[left, mid] and a[mid+1, right]
    private static <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right) {
        int bLength = right - left + 1;
        T[] b = Arrays.copyOf(a, bLength);
        int i = 0;
        int i1 = left;
        int i2 = mid+1;
        while (i1 <= mid && i2 <= right) {
            if (a[i1].compareTo(a[i2]) <= 0) {
                b[i] = a[i1];
                i1++;
            } else {
                b[i] = a[i2];
                i2++;
            }
            i++;
            countCompare++;
        }
        while (i1 <= mid) b[i++] = a[i1++];
        while (i2 <= right) b[i++] = a[i2++];
        i = 0;
        while (i < bLength) a[i+left] = b[i++];
    }


    // sort and return time in milliseconds
    public static <T extends Comparable<T>> long timeSort(T[] a) {
        long start = System.currentTimeMillis();
        mergeSort0(a, 0, a.length-1);
        return System.currentTimeMillis() - start;
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void mergeSort0(T[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort0(a, left, mid);
            mergeSort0(a, mid + 1, right);
            merge0(a, left, mid, right);
        }
    }

    // merge two sorted sub-array a[left, mid] and a[mid+1, right]
    private static <T extends Comparable<T>> void merge0(T[] a, int left, int mid, int right) {
        int bLength = right - left + 1;
        T[] b = Arrays.copyOf(a, bLength);
        int i = 0;
        int i1 = left;
        int i2 = mid+1;
        while (i1 <= mid && i2 <= right) {
            if (a[i1].compareTo(a[i2]) <= 0) {
                b[i] = a[i1];
                i1++;
            } else {
                b[i] = a[i2];
                i2++;
            }
            i++;
        }
        while (i1 <= mid) b[i++] = a[i1++];
        while (i2 <= right) b[i++] = a[i2++];
        i = 0;
        while (i < bLength) a[i+left] = b[i++];
    }
}
