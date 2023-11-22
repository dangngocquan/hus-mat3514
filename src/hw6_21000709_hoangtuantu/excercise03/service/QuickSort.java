package hw6_21000709_hoangtuantu.excercise03.service;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(T[] array, int low, int high ) {
        while (low < high) {
            int pivotIndex = partition(array, low, high);
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(array, low, pivotIndex - 1);
                low = pivotIndex + 1;
            } else {
                quickSort(array, pivotIndex + 1, high);
                high = pivotIndex - 1;
            }
        }
    }

    public int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((array[j].compareTo(pivot) < 0)) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
