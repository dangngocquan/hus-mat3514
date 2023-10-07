package hw2_21000676_damhaidang.ex4;

import java.util.Scanner;

public class Exercise41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = importArray(scanner);
        bubbleSort(array);
        print(array);
    }

    // Create array
    public static int[] importArray(Scanner sc) {
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i= 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    // Print array
    public static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();;
    }

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int idx1 = 0; idx1 < length; idx1++) {
            boolean isSorted = true;        // Assume the array is sorted before loop
            for (int idx2 = 1; idx2 < length - idx1; idx2++) {
                if (array[idx2 - 1] > array[idx2]) {
                    swap(array, idx2 - 1, idx2);
                    isSorted = false;       // Any swapping will kill the assumption
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    // Swap 2 elements in the array
    public static void swap(int[] array, int idx1, int idx2) {
        array[idx1] ^= array[idx2];
        array[idx2] ^= array[idx1];
        array[idx1] ^= array[idx2];
    }
}
