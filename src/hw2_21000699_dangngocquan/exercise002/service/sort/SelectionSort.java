package hw2_21000699_dangngocquan.exercise002.service.sort;

import java.util.Arrays;

public class SelectionSort {
    // sort and return data [countCompare, countSwap]
    public static <T extends Comparable<T>> int[] sort(T[] a) {
        int countCompare = 0;
        int countSwap = 0;

        System.out.printf("%-15s: %s\n",
                "Initial array",
                Arrays.toString(a));

        for (int i = 0; i < a.length-1; i++) {
            int indexOfMinValue = i;
            for (int j = i+1; j < a.length; j++) {
                countCompare++;
                if (a[j].compareTo(a[indexOfMinValue]) < 0) {
                    indexOfMinValue = j;
                }
            }
            if (indexOfMinValue != i) {
                T temp = a[indexOfMinValue];
                a[indexOfMinValue] = a[i];
                a[i] = temp;
                countSwap++;
            }

            System.out.printf("%-15s: %s\n",
                    String.format("After loop %d", i+1),
                    Arrays.toString(a));
        }

        return new int[] {countCompare, countSwap};
    }

    // sort and return time in milliseconds
    public static <T extends Comparable<T>> long timeSort(T[] a) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length-1; i++) {
            int indexOfMinValue = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j].compareTo(a[indexOfMinValue]) < 0) {
                    indexOfMinValue = j;
                }
            }
            if (indexOfMinValue != i) {
                T temp = a[indexOfMinValue];
                a[indexOfMinValue] = a[i];
                a[i] = temp;
            }
        }
        return System.currentTimeMillis() - start;
    }
}
