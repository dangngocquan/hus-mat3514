package hw2_21000709_hoangtuantu.exercise02;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1, true);
    }

    @Override
    public void sort(T[] array, boolean ascending) {
        quickSort(array, 0, array.length - 1, ascending);
    }

    public void quickSort(T[] array, int low, int high, boolean ascending ) {
        while (low < high) {
            int pivotIndex = partition(array, low, high, ascending);
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(array, low, pivotIndex - 1, ascending);
                low = pivotIndex + 1;
            } else {
                quickSort(array, pivotIndex + 1, high, ascending);
                high = pivotIndex - 1;
            }
        }
    }

    public int partition(T[] array, int low, int high, boolean ascending) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? (array[j].compareTo(pivot) < 0) : (array[j].compareTo(pivot) > 0)) {
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
