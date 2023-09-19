package hw2_21000699_dangngocquan.exercise001.service.sort;

import java.util.Arrays;

public class InsertionSort {
    // sort and return data [countCompare, countSwap]
    public static int[] sort(int[] a) {
        int countCompare = 0;
        int countSwap = 0;

        System.out.printf("%-15s: %s\n",
                "Initial array",
                Arrays.toString(a));

        for (int i = 1; i < a.length; i++) {
            int valueInsert = a[i];
            int j = i-1;
            while (j >= 0) {
                countCompare++;
                if (a[j] > valueInsert) {
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
    public static long timeSort(int[] a) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < a.length; i++) {
            int valueInsert = a[i];
            int j = i-1;
            while (j >= 0) {
                if (a[j] > valueInsert) {
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
