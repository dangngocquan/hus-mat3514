package hw2_21000506_nguyenthithanhhuong.ex1;

public class SelectionSort {
    // Selection Sort method
    public static void selectionSort(int[] array) {
        int countCompare = 0;
        int countChange = 0;

        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                countCompare++;
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                    countChange++;
                }
            }
            int temp = array[i];
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
    public static long time(int[] array) {
        long start =  System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}
