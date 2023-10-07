package hw2_21000506_nguyenthithanhhuong.ex1;

public class QuickSort {
    private static int countCompare = 0;
    private static int countChange = 0;

    // Quick Sort method
    public static void quickSort(int[] array) {
        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        quickSort0(array, 0, array.length - 1);

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));


        System.out.println("Numbers of comparison: " + countCompare);
        System.out.println("Numbers of swap: " + countChange);
    }
    public static void quickSort0(int[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSort0(array, low, pivotIdx - 1);
            quickSort0(array, pivotIdx + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;

        for (int k = low + 1; k <= high; k++) {
            countCompare++;
            if (array[k] < pivot) {
                i++;
                swap(array, k, i);
                countChange++;
            }
        }
        swap(array, low, i);
        countChange++;
        System.out.printf("After partition array[%d, %d]: ", low, high);
        System.out.println(CreateArray.printArray(array));
        return i;
    }

    public static void swap(int[] array, int i, int m) {
        int temp = array[i];
        array[i] = array[m];
        array[m] = temp;
    }

    public static void quickSort1(int[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition1(array, low, high);

            quickSort1(array, low, pivotIdx - 1);
            quickSort1(array, pivotIdx + 1, high);
        }
    }

    public static int partition1(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;

        for (int k = low + 1; k <= high; k++) {
            if (array[k] < pivot) {
                i++;
                swap(array, k, i);
            }
        }
        swap(array, low, i);
        return i;
    }

    // Quick Sort time method
    public static long time(int[] array) {
        long start =  System.currentTimeMillis();

        quickSort1(array, 0, array.length - 1);

        long end = System.currentTimeMillis();
        return end - start;
    }
}
