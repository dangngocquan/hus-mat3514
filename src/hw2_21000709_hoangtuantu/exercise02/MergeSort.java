package hw2_21000709_hoangtuantu.exercise02;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] numbers) {
        mergeSort(numbers,  true);
    }

    @Override
    public void sort(T[] numbers, boolean ascending) {
        mergeSort(numbers, ascending);
    }

    public void mergeSort(T[] array, boolean ascending) {
        if (array == null || array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left, ascending);
        mergeSort(right, ascending);
        merge(array, left, right, ascending);
    }

    public void merge(T[] numbers, T[] left, T[] right, boolean ascending) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (ascending) {
                if (left[i].compareTo(right[j]) < 0) {
                    numbers[k++] = left[i++];
                } else {
                    numbers[k++] = right[j++];
                }
            } else {
                if (left[i].compareTo(right[j]) > 0) {
                    numbers[k++] = left[i++];
                } else {
                    numbers[k++] = right[j++];
                }
            }
        }

        while (i < left.length) {
            numbers[k++] = left[i++];
        }

        while (j < right.length) {
            numbers[k++] = right[j++];
        }
    }
}
