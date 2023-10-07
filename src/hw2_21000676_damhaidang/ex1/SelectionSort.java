package hw2_21000676_damhaidang.ex1;

public class SelectionSort extends SimpleSort{
    public SelectionSort() {
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
        System.out.println("Selection sort: " + time / 20 + " nano seconds");
    }

    // Selection Sort:
    @Override
    protected void sort(int[] array) {
        int length = array.length;
        // One by one move boundary of unsorted array
        for (int idx1 = length - 1; idx1 > 0; --idx1) {
            // Find the minimum element in unsorted array
            int maxIdx = idx1;
            for (int idx2 = 0; idx2 < idx1; ++idx2) {
                compareCount++;
                if (array[idx2] >= array[maxIdx])
                    maxIdx = idx2;
            }
            // Swap the found minimum element with the first element
            swap(array, idx1, maxIdx);
            swapCount++;
            print(array);
        }
        System.out.println("So lan so sanh: " + compareCount);
        System.out.println("So lan doi cho: " + swapCount + "\n");
    }
}
