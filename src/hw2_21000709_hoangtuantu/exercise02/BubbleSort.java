package hw2_21000709_hoangtuantu.exercise02;


public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] arr) {
        sort(arr, true);
    }

    @Override
    public void sort(T[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (ascending ? arr[j].compareTo(arr[j + 1]) > 0 : arr[j].compareTo(arr[j + 1]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
