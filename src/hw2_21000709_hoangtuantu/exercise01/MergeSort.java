package hw2_21000709_hoangtuantu.exercise01;

public class MergeSort implements Sort{

    @Override
    public void sort(int[] numbers) {
        sort(numbers,  true, false);
    }

    @Override
    public void sort(int[] numbers, boolean ascending) {
        sort(numbers, ascending, false);
    }
    @Override
    public void sort(int[] numbers, boolean ascending, boolean stepByStep) {
        mergeSort(numbers, ascending);
    }

    public void mergeSort(int[] numbers, boolean ascending) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        int mid = numbers.length / 2;
        int[] left = new int[mid];
        int[] right = new int[numbers.length - mid];

        System.arraycopy(numbers, 0, left, 0, mid);
        System.arraycopy(numbers, mid, right, 0, numbers.length - mid);

        mergeSort(left, ascending);
        mergeSort(right, ascending);
        merge(numbers, left, right, ascending);
    }

    public void merge(int[] numbers, int[] left, int[] right, boolean ascending) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (ascending) {
                if (left[i] < right[j]) {
                    numbers[k++] = left[i++];
                } else {
                    numbers[k++] = right[j++];
                }
            } else {
                if (left[i] > right[j]) {
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
