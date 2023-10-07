package hw2_21000676_damhaidang.ex1;

public class InsertionSort extends SimpleSort{
    public InsertionSort() {

    }

    public void test(int length) {
        for (int idx1= 0; idx1< 20; idx1++) {
            long start = System.nanoTime();
            int[] arr1 = generateArray(length);
            sort(arr1);
            long afterSort = System.nanoTime();
            time += (afterSort - start);
        }
        System.out.println("Insertion sort: " + time / 20 + " nano seconds");
    }

    // Insertion Sort:
    @Override
    protected void sort(int[] array) {
        int length = array.length;
        for (int idx1 = 0; idx1 < length; ++idx1) {
            int next = array[idx1];
            int j = idx1 - 1;
            /* Move elements of arr[0...i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > next) {
                compareCount++;
                array[j + 1] = array[j];
                swapCount++;
                j = j - 1;
                print(array);
            }
            array[j + 1] = next;
            swapCount++;
            print(array);
        }
        System.out.println("So lan so sanh: " + compareCount);
        System.out.println("So lan doi cho: " + swapCount + "\n");
    }

}
