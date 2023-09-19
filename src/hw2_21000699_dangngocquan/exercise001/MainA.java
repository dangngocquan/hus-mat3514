package hw2_21000699_dangngocquan.exercise001;

import hw2_21000699_dangngocquan.exercise001.service.sort.Sort;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Get input ...");
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = scanner.nextInt();
        }
        scanner.close();
        // Sample:
        // Get input ...
        // Enter n: 10
        // a[0] = 5
        // a[1] = 9
        // a[2] = 3
        // a[3] = 1
        // a[4] = 8
        // a[5] = 2
        // a[6] = 7
        // a[7] = 4
        // a[8] = 6
        // a[9] = 0

        System.out.println("\nSort ...");

        System.out.println("1. Bubble sort:");
        Sort.bubbleSort(a.clone());
        // 1. Bubble sort:
        // Initial array  : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After loop 1   : [5, 3, 1, 8, 2, 7, 4, 6, 0, 9]
        // After loop 2   : [3, 1, 5, 2, 7, 4, 6, 0, 8, 9]
        // After loop 3   : [1, 3, 2, 5, 4, 6, 0, 7, 8, 9]
        // After loop 4   : [1, 2, 3, 4, 5, 0, 6, 7, 8, 9]
        // After loop 5   : [1, 2, 3, 4, 0, 5, 6, 7, 8, 9]
        // After loop 6   : [1, 2, 3, 0, 4, 5, 6, 7, 8, 9]
        // After loop 7   : [1, 2, 0, 3, 4, 5, 6, 7, 8, 9]
        // After loop 8   : [1, 0, 2, 3, 4, 5, 6, 7, 8, 9]
        // After loop 9   : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Number compare elements: 45
        // Number swap elements: 28

        System.out.println("\n2. Selection sort:");
        Sort.selectionSort(a.clone());
        // 2. Selection sort:
        // Initial array  : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After loop 1   : [0, 9, 3, 1, 8, 2, 7, 4, 6, 5]
        // After loop 2   : [0, 1, 3, 9, 8, 2, 7, 4, 6, 5]
        // After loop 3   : [0, 1, 2, 9, 8, 3, 7, 4, 6, 5]
        // After loop 4   : [0, 1, 2, 3, 8, 9, 7, 4, 6, 5]
        // After loop 5   : [0, 1, 2, 3, 4, 9, 7, 8, 6, 5]
        // After loop 6   : [0, 1, 2, 3, 4, 5, 7, 8, 6, 9]
        // After loop 7   : [0, 1, 2, 3, 4, 5, 6, 8, 7, 9]
        // After loop 8   : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // After loop 9   : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Number compare elements: 45
        // Number swap elements: 8

        System.out.println("\n3. Insertion sort:");
        Sort.insertionSort(a.clone());
        // 3. Insertion sort:
        // Initial array  : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After loop 1   : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After loop 2   : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After loop 3   : [1, 3, 5, 9, 8, 2, 7, 4, 6, 0]
        // After loop 4   : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After loop 5   : [1, 2, 3, 5, 8, 9, 7, 4, 6, 0]
        // After loop 6   : [1, 2, 3, 5, 7, 8, 9, 4, 6, 0]
        // After loop 7   : [1, 2, 3, 4, 5, 7, 8, 9, 6, 0]
        // After loop 8   : [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        // After loop 9   : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Number compare elements: 34
        // Number swap elements: 28

        System.out.println("\n4. Merge sort:");
        Sort.mergeSort(a.clone());
        // 4. Merge sort:
        // Initial array                 : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[0, 0]            : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[1, 1]            : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After merge a[0, 1]           : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[0, 1]            : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[2, 2]            : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After merge a[0, 2]           : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[0, 2]            : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[3, 3]            : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[4, 4]            : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After merge a[3, 4]           : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After sort a[3, 4]            : [3, 5, 9, 1, 8, 2, 7, 4, 6, 0]
        // After merge a[0, 4]           : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After sort a[0, 4]            : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After sort a[5, 5]            : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After sort a[6, 6]            : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After merge a[5, 6]           : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After sort a[5, 6]            : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After sort a[7, 7]            : [1, 3, 5, 8, 9, 2, 7, 4, 6, 0]
        // After merge a[5, 7]           : [1, 3, 5, 8, 9, 2, 4, 7, 6, 0]
        // After sort a[5, 7]            : [1, 3, 5, 8, 9, 2, 4, 7, 6, 0]
        // After sort a[8, 8]            : [1, 3, 5, 8, 9, 2, 4, 7, 6, 0]
        // After sort a[9, 9]            : [1, 3, 5, 8, 9, 2, 4, 7, 6, 0]
        // After merge a[8, 9]           : [1, 3, 5, 8, 9, 2, 4, 7, 0, 6]
        // After sort a[8, 9]            : [1, 3, 5, 8, 9, 2, 4, 7, 0, 6]
        // After merge a[5, 9]           : [1, 3, 5, 8, 9, 0, 2, 4, 6, 7]
        // After sort a[5, 9]            : [1, 3, 5, 8, 9, 0, 2, 4, 6, 7]
        // After merge a[0, 9]           : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Number compare elements: 23
        // Number swap elements: 0

        System.out.println("\n5. Quick sort:");
        Sort.quickSort(a.clone());
        // 5. Quick sort:
        // Initial array                 : [5, 9, 3, 1, 8, 2, 7, 4, 6, 0]
        // After partition a[0, 9]       : [0, 3, 1, 2, 4, 5, 7, 8, 6, 9]
        // After partition a[0, 4]       : [0, 3, 1, 2, 4, 5, 7, 8, 6, 9]
        // After partition a[1, 4]       : [0, 2, 1, 3, 4, 5, 7, 8, 6, 9]
        // After partition a[1, 2]       : [0, 1, 2, 3, 4, 5, 7, 8, 6, 9]
        // After partition a[6, 9]       : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // After partition a[8, 9]       : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Number compare elements: 21
        // Number swap elements: 15
    }
}
