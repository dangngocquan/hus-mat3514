package hw2_21000676_damhaidang.ex1;

public class MergeSort extends EffectiveSort{
    private int compareCount = 0;

    public MergeSort() {
        super();
    }

    public void test(int length) {
        for (int idx1= 0; idx1 < 20; idx1++) {
            long start = System.nanoTime();
            int[] arr1 = generateArray(length);
            sort(arr1, 0, length - 1);
            long afterSort = System.nanoTime();
            time += (afterSort - start);
        }
        System.out.println("So lan so sanh: " + compareCount);
        System.out.println("Merge sort: " + time / 20 + " nano seconds");
    }

    /* Merge Sort:

     */
    private void merge(int[] arr, int start, int mid, int end) {
        int interval  = end - start + 1;
        int[] tempArr = new int[interval];
        int left = start, right = mid + 1, tempIdx = 0;

        while (left <= mid && right <= end) {
            compareCount++;
            if (arr[left] <= arr[right]) {
                tempArr[tempIdx++] = arr[left++];
                print(tempArr);
                print(arr);
                System.out.println();
            } else {
                tempArr[tempIdx++] = arr[right++];
                print(tempArr);
                print(arr);
                System.out.println();
            }
        }
    }

    // Main function that sorts arr[l..r] using merge()
    protected void sort(int[] arr, int left, int right) {
        if (left < right) {

            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
}
