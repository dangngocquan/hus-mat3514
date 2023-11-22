package hw6_21000506_nguyenthithanhhuong.ex03.sort;

public class QuickSort {
    public static  <T extends Comparable<T>> T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSort(array, low, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[low];
        int i = low;

        for (int k = low + 1; k <= high; k++) {
            if (array[k].compareTo(pivot) < 0) {
                i++;
                swap(array, k, i);
            }
        }
        swap(array, low, i);
        return i;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int m) {
        T temp = array[i];
        array[i] = array[m];
        array[m] = temp;
    }

    public static <T extends Comparable<T>> long time(T[] array) {
        long start =  System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
