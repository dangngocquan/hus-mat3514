package hw2_21000506_nguyenthithanhhuong.ex2;

public class SelectionSort {
    // Selection Sort method
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        int countCompare = 0;
        int countChange = 0;

        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                countCompare++;
                if (array[j].compareTo(array[minIdx]) < 0) {
                    minIdx = j;
                    countChange++;
                }
            }
            T temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
            System.out.printf("After loop %d: ", i + 1);
            System.out.println(CreateArray.printArray(array));
        }

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));

        System.out.println("Numbers of comparison: " + countCompare);
        System.out.println("Numbers of swap: " + countChange);
    }

    // Selection Sort time method
    public static <T extends Comparable<T>>  long time(T[] array) {
        long start =  System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}
