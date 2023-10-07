package hw2_21000676_damhaidang.ex1;

public class QuickSort extends EffectiveSort {
    public QuickSort() {

    }

    public void test(int length) {
        for (int i= 0; i < 20; i++) {
            long start = System.nanoTime();
            int[] arr1 = generateArray(length);
            sort(arr1, 0, length - 1);
            long afterSort = System.nanoTime();
            time += (afterSort - start);
        }
        System.out.println("So lan so sanh: " + compareCount);
        System.out.println("So lan doi cho: " + swapCount + "\n");
        System.out.println("Quick sort: " + time / 20 + " nano seconds");
    }

    /* Insertion Sort:
     */
    protected void sort(int[] array, int start, int end) {
        if (start < end) {

            int pivot = partition(array, start, end);

            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int idx1 = (low - 1); // index of smaller element
        for (int idx2 = low; idx2 < high; idx2++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[idx2] <= pivot) {
                compareCount++;
                idx1++;
                swapCount++;

                // swap arr[i] and arr[j]
                swap(arr, idx1, idx2);
                print(arr);
            }
        }
        swapCount++;
        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, idx1 + 1, high);
        print(arr);
        return idx1 + 1;
    }
}
