package hw2_21000709_hoangtuantu.exercise01;

public class QuickSort implements Sort{
    @Override
    public void sort(int[] numbers) {
        sort(numbers, true, false);
    }
    @Override
    public void sort(int[] numbers, boolean ascending) {
        sort(numbers, ascending, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending, boolean stepByStep) {
        quickSort(numbers, 0, numbers.length - 1, ascending);
    }

    public void quickSort(int[] numbers, int low, int high, boolean ascending ) {
        while (low < high) {
            int pivotIndex = partition(numbers, low, high, ascending);
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(numbers, low, pivotIndex - 1, ascending);
                low = pivotIndex + 1;
            } else {
                quickSort(numbers, pivotIndex + 1, high, ascending);
                high = pivotIndex - 1;
            }
        }
    }

    public int partition(int[] numbers, int low, int high, boolean ascending) {
        int pivot = numbers[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? (numbers[j] < pivot) : (numbers[j] > pivot)) {
                i++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        int temp = numbers[i + 1];
        numbers[i + 1] = numbers[high];
        numbers[high] = temp;
        return i + 1;
    }
}
