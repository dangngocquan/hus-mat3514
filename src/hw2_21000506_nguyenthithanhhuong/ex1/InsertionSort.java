package hw2_21000506_nguyenthithanhhuong.ex1;

public class InsertionSort {
    // insertion Sort method
    public static void insertionSort(int[] array) {
        int countCompare = 0;
        int countChange = 0;

        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0) {
                countCompare++;
                if (array[j] > key) {
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
    public static long time(int[] array) {
        long start =  System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0) {
                if (array[j] > key) {
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
