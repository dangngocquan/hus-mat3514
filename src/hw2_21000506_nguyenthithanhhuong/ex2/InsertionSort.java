package hw2_21000506_nguyenthithanhhuong.ex2;

public class InsertionSort {
    // insertion Sort method
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        int countCompare = 0;
        int countChange = 0;

        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0) {
                countCompare++;
                if (array[j].compareTo(key) > 0) {
                    countChange++;
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;

            System.out.printf("After loop %d: ", i);
            System.out.println(CreateArray.printArray(array));
        }

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));

        System.out.println("Numbers of comparison: " + countCompare);
        System.out.println("Numbers of swap: " + countChange);
    }

    // Insertion Sort time method
    public static <T extends Comparable<T>>  long time(T[] array) {
        long start =  System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0) {
                if (array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}
