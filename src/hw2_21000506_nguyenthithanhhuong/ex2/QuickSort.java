package hw2_21000506_nguyenthithanhhuong.ex2;

public class QuickSort {
    private static int countCompare = 0;
    private static int countChange = 0;

    // Quick Sort method
    public static <T extends Comparable<T>>  void quickSort(T[] array) {
        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        quickSort0(array, 0, array.length - 1);

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));


        System.out.println("Numbers of comparison: " + countCompare);
        System.out.println("Numbers of swap: " + countChange);
    }
    public static <T extends Comparable<T>> void quickSort0(T[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSort0(array, low, pivotIdx - 1);
            quickSort0(array, pivotIdx + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[low];
        int i = low;

        for (int k = low + 1; k <= high; k++) {
            countCompare++;
            if (array[k].compareTo(pivot) < 0) {
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

    public static <T extends Comparable<T>> void swap(T[] array, int i, int m) {
        T temp = array[i];
        array[i] = array[m];
        array[m] = temp;
    }

    public static <T extends Comparable<T>> void quickSort1(T[] array, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition1(array, low, high);

            quickSort1(array, low, pivotIdx - 1);
            quickSort1(array, pivotIdx + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition1(T[] array, int low, int high) {
        T pivot = array[low];
        int i = low;

        for (int k = low + 1; k <= high; k++) {
            if (array[k].compareTo(pivot) < 0) {
                i++;
                swap(array, k, i);
            }
        }
        swap(array, low, i);
        return i;
    }

    // Quick Sort time method
    public static <T extends Comparable<T>> long time(T[] array) {
        long start =  System.currentTimeMillis();

        quickSort1(array, 0, array.length - 1);

        long end = System.currentTimeMillis();
        return end - start;
    }
}
