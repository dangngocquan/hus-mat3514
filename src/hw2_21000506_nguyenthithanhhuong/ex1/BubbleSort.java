package hw2_21000506_nguyenthithanhhuong.ex1;

public class BubbleSort {
    // Bubble Sort method
    public static void bubbleSort(int[] array) {
        int countCompare = 0;
        int countChange = 0;

        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        for (int i = 0; i < array.length; i++) {
            boolean isSort = true;
            for (int j = 1; j < array.length - i; j++) {
                countCompare++;
                if (array[j - 1] > array[j]) {
                    countChange++;
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) break;
            System.out.printf("After loop %d: ", i + 1);
            System.out.println(CreateArray.printArray(array));
        }

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));

        System.out.println("Numbers of comparison: " + countCompare);
        System.out.println("Numbers of swap: " + countChange);
    }

    // Bubble Sort time method
    public static long time(int[] array) {
        long start =  System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            boolean isSort = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) break;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
