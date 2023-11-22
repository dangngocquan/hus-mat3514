package hw6_21000709_hoangtuantu.excercise03.service;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] numbers) {
        mergeSort(numbers);
    }

    public void mergeSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public void merge(T[] numbers, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0){
                numbers[k++] = left[i++];
            } else{
                numbers[k++] = right[j++];
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
