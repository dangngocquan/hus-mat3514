package hw2_21000676_damhaidang.ex4;

import java.util.Scanner;

public class Exercise43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = importArray(scanner);
        selectionSort(array);
        print(array);
    }

    // Create array
    public static int[] importArray(Scanner sc) {
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
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

    // Selection sort
    public static void selectionSort(int[] array) {
        int length = array.length;
        for (int idx1 = length - 1; idx1 > 0; --idx1) {
            // Searching for maximum element
            int maxIdx = idx1;
            for (int idx2 = 0; idx2 < idx1; ++idx2) {
                if (array[idx2] >= array[maxIdx])
                    maxIdx = idx2;
            }
            // Swap maximum element with the last item
            swap(array, idx1, maxIdx);
        }
    }

    // Swap 2 elements in the array
    public static void swap(int[] array, int idx1, int idx2) {
        array[idx1] ^= array[idx2];
        array[idx2] ^= array[idx1];
        array[idx1] ^= array[idx2];
    }
}
