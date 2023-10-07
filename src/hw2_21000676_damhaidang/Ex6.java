package hw2_21000676_damhaidang;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();                  // Length of array
        int k = scanner.nextInt();          //
        int[] array = importArray(scanner, length);


        selectionSort(array);
        int result = getElement(array, k - 1);
        System.out.println(result);
        scanner.close();
    }

    // Create array
    public static int[] importArray(Scanner scanner, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Swap 2 elements in array
    public static void swap(int[] array, int idx1, int idx2) {
        array[idx1] ^= array[idx2];
        array[idx2] ^= array[idx1];
        array[idx1] ^= array[idx2];
    }

    // Selection sort:
    public static void selectionSort(int[] array) {
        int length = array.length;
        for (int idx1 = length - 1; idx1 > 0; --idx1) {
            int maxIdx = idx1;
            for (int idx2 = 0; idx2 < idx1; ++idx2) {
                if (array[idx2] >= array[maxIdx])
                    maxIdx = idx2;
            }
            swap(array, idx1, maxIdx);
        }
    }

    // get the element at the specified index
    public static int getElement(int[] arr, int number) {
        return arr[number];
    }
}
