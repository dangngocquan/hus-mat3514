package hw2_21000676_damhaidang;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = importArray(scanner);
        insertionSort(values);
        print(values);
        scanner.close();
    }

    // Print array
    public static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
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

    // Insertion sort:
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int idx1 = 1; idx1 < n; idx1++) {
            int key = arr[idx1];
            int idx2 = idx1 - 1;

            // Move elements of arr[0...i-1], that are greater than key, to one position ahead of their current position
            while (idx2 >= 0 && arr[idx2] > key) {
                arr[idx2 + 1] = arr[idx2];
                idx2 = idx2 - 1;
            }
            arr[idx2 + 1] = key;
        }
    }
}
