package hw6_21000506_nguyenthithanhhuong.ex03.sort;

import java.util.Arrays;

public class MergeSort {
    public static  <T extends Comparable<T>> T[] sort(T[] array) {
            mergeSort(array, 0, array.length -1);
            return array;
    }
    public static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(array, low, mid);

            mergeSort(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 =  high - mid;
        T[] L = Arrays.copyOf(array, n1);
        T[] R = Arrays.copyOf(array, n2);
        for (i = 0; i < n1; i++){
            L[i] = array[low + i];
        }
        for (j = 0; j < n2; j++){
            R[j] = array[mid + 1+ j];
        }
        i = 0;
        j = 0;
        k = low;
        while (i < n1 && j < n2){
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            array[k] = R[j];
            j++;
            k++;
        }
    }
    public static <T extends Comparable<T>> long time(T[] array) {
        long start =  System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
