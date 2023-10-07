package hw2_21000676_damhaidang.ex1;

public abstract class Sort {
    protected int compareCount = 0;
    protected int swapCount = 0;

    protected long time = 0;

    public Sort() {

    }


    // Print array
    protected void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Swap 2 elements in the array
    protected void swap(int[] array, int idx1, int idx2) {
        array[idx1] ^= array[idx2];
        array[idx2] ^= array[idx1];
        array[idx1] ^= array[idx2];
    }

    // Create a new array
    protected int[] generateArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * Math.pow(10, 6)) + 1;
        }
        return array;
    }
}
