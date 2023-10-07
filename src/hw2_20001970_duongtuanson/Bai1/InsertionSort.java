package hw2_20001970_duongtuanson.Bai1;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
