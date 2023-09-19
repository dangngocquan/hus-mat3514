package hw2_21000699_dangngocquan.exercise002.service.sort;

import java.util.Arrays;

public class InsertionSort {
    // sort and return data [countCompare, countSwap]
    public static <T extends Comparable<T>> int[] sort(T[] a) {
        int countCompare = 0;
        int countSwap = 0;

        System.out.printf("%-15s: %s\n",
                "Initial array",
                Arrays.toString(a));

        for (int i = 1; i < a.length; i++) {
            T valueInsert = a[i];
            int j = i-1;
            while (j >= 0) {
                countCompare++;
                if (a[j].compareTo(valueInsert) > 0) {
                    countSwap++;
                    a[j+1] = a[j];
                    j--;
                } else {
                    break;
                }
            }
            a[j+1] = valueInsert;

            System.out.printf("%-15s: %s\n",
                    String.format("After loop %d", i),
                    Arrays.toString(a));
        }

        return new int[] {countCompare, countSwap};
    }

    // sort and return time in milliseconds
    public static <T extends Comparable<T>> long timeSort(T[] a) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < a.length; i++) {
            T valueInsert = a[i];
            int j = i-1;
            while (j >= 0) {
                if (a[j].compareTo(valueInsert) > 0) {
                    a[j+1] = a[j];
                    j--;
                } else {
                    break;
                }
            }
            a[j+1] = valueInsert;
        }

        return System.currentTimeMillis() - start;
    }
}
