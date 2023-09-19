package hw2_21000699_dangngocquan.exercise002.service.sort;

import java.util.Arrays;

public class BubbleSort {
    // sort and return data [countCompare, countSwap]
    public static <T extends Comparable<T>> int[] sort(T[] a) {
        int countCompare = 0;
        int countSwap = 0;

        System.out.printf("%-15s: %s\n",
                "Initial array",
                Arrays.toString(a));

        for (int i = 0; i < a.length-1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < a.length-i; j++) {
                countCompare++;
                if (a[j-1].compareTo(a[j]) > 0) {
                    countSwap++;
                    isSorted = false;
                    T temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            System.out.printf("%-15s: %s\n",
                    String.format("After loop %d", i+1),
                    Arrays.toString(a));
            if (isSorted) break;
        }

        return new int[] {countCompare, countSwap};
    }

    // sort and return time in milliseconds
    public static <T extends Comparable<T>> long timeSort(T[] a) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length-1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < a.length-i; j++) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    isSorted = false;
                    T temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            if (isSorted) break;
        }
        return System.currentTimeMillis() - start;
    }
}
