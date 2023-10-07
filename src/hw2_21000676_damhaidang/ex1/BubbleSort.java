package hw2_21000676_damhaidang.ex1;

public class BubbleSort extends SimpleSort{
    public BubbleSort() {
        super();
    }

    public void test(int length) {
        for (int i = 0; i < 20; i++) {
            long start = System.nanoTime();
            int[] arr1 = generateArray(length);
            sort(arr1);
            long afterSort = System.nanoTime();
            time += (afterSort - start);
        }
        System.out.println("Bubble sort: " + time / 20 + " nano seconds");
    }

    /* Bubble Sort:
     1. Traverse from left and compare adjacent elements and the higher one is placed at right side.
     2. This process is then continued to find the second largest and place it and so on until the data is sorted.
     */

    @Override
    protected void sort(int[] array) {
        for (int idx1 = 0; idx1 < array.length; idx1++) {
            boolean isSorted = true;        // Assume the array is sorted before loop
            for (int idx2 = 1; idx2 < array.length; idx2++) {
                compareCount++;
                if (array[idx2 - 1] > array[idx2]) {
                    swap(array, idx2 - 1, idx2);        // Any swapping will kill the assumption
                    isSorted = false;
                    swapCount++;
                    print(array);
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (isSorted) {
                break;
            }
        }
        System.out.println("So lan so sanh: " + compareCount);
        System.out.println("So lan doi cho: " + swapCount + "\n");
    }
}
