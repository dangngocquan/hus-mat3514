package hw2_21000506_nguyenthithanhhuong.ex1;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define length of array read by keyboard
        System.out.println("Enter the length of array (keyboard): ");
        int length1 = sc.nextInt();

        int[] array1 = new int[length1];

        // Read elements of an array by keyboard
        System.out.println("Enter elements of array by keyboard: ");
        CreateArray.createArrayByKeyboard(sc, array1);

        // Define length of array random
        System.out.println("Enter the length of array (random): ");
        int length2 = sc.nextInt();
        sc.close();

        // Create array random
        int[] array2 = new int[length2];
        CreateArray.createRandomArray(array2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Print array read by keyboard
        System.out.println("Array read by keyboard: ");
        System.out.println(CreateArray.printArray(array1));

        // Print array random
        System.out.println("Array random: ");
        System.out.println(CreateArray.printArray(array2));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Sort
        // Bubble Sort
        System.out.println("Bubble Sort: ");
        System.out.println("Array 1: ");
        BubbleSort.bubbleSort(Arrays.copyOfRange(array1, 0, array1.length));
        System.out.println("Array 2: ");
        BubbleSort.bubbleSort(Arrays.copyOfRange(array2, 0, array2.length));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Selection Sort
        System.out.println("Selection Sort: ");
        System.out.println("Array 1: ");
        SelectionSort.selectionSort(Arrays.copyOfRange(array1, 0, array1.length));
        System.out.println("Array 2: ");
        SelectionSort.selectionSort(Arrays.copyOfRange(array2, 0, array2.length));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Insertion Sort
        System.out.println("Insertion Sort: ");
        System.out.println("Array 1: ");
        InsertionSort.insertionSort(Arrays.copyOfRange(array1, 0, array1.length));
        System.out.println("Array 2: ");
        InsertionSort.insertionSort(Arrays.copyOfRange(array2, 0, array2.length));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Merge Sort
        System.out.println("Merge Sort: ");
        System.out.println("Array 1: ");
        MergeSort.mergeSort(Arrays.copyOfRange(array1, 0, array1.length));
        System.out.println("Array 2: ");
        MergeSort.mergeSort(Arrays.copyOfRange(array2, 0, array2.length));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Quick Sort
        System.out.println("Quick Sort: ");
        System.out.println("Array 1: ");
        QuickSort.quickSort(Arrays.copyOfRange(array1, 0, array1.length));
        System.out.println("Array 2: ");
        QuickSort.quickSort(Arrays.copyOfRange(array2, 0, array2.length));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Sort time
        System.out.println("Sort time...");

        // Create random array with N = 100
        int[] arrTest1 = new int[100];
        CreateArray.createRandomArray(arrTest1);

        // Create random array with N = 1000
        int[] arrTest2 = new int[1000];
        CreateArray.createRandomArray(arrTest2);

        // Create random array with N = 10000
        int[] arrTest3 = new int[10000];
        CreateArray.createRandomArray(arrTest3);

        // Create random array with N = 100000
        int[] arrTest4 = new int[100000];
        CreateArray.createRandomArray(arrTest4);

        TimeSort.timeSort(arrTest1);
        TimeSort.timeSort(arrTest2);
        TimeSort.timeSort(arrTest3);
        TimeSort.timeSort(arrTest4);
    }
//    Enter the length of array (keyboard):
//    5
//    Enter elements of array by keyboard:
//    2 6 3 5 1
//    Enter the length of array (random):
//    5
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Array read by keyboard:
//    [2, 6, 3, 5, 1]
//    Array random:
//    [136879, 653803, 168639, 374079, 402875]
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Bubble Sort:
//    Array 1:
//    Input array: [2, 6, 3, 5, 1]
//    After loop 1: [2, 3, 5, 1, 6]
//    After loop 2: [2, 3, 1, 5, 6]
//    After loop 3: [2, 1, 3, 5, 6]
//    After loop 4: [1, 2, 3, 5, 6]
//    After loop 5: [1, 2, 3, 5, 6]
//    Array after sort: [1, 2, 3, 5, 6]
//    Numbers of comparison: 10
//    Numbers of swap: 6
//    Array 2:
//    Input array: [136879, 653803, 168639, 374079, 402875]
//    After loop 1: [136879, 168639, 374079, 402875, 653803]
//    After loop 2: [136879, 168639, 374079, 402875, 653803]
//    Array after sort: [136879, 168639, 374079, 402875, 653803]
//    Numbers of comparison: 7
//    Numbers of swap: 3
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Selection Sort:
//    Array 1:
//    Input array: [2, 6, 3, 5, 1]
//    After loop 1: [1, 6, 3, 5, 2]
//    After loop 2: [1, 2, 3, 5, 6]
//    After loop 3: [1, 2, 3, 5, 6]
//    Array after sort: [1, 2, 3, 5, 6]
//    Numbers of comparison: 10
//    Numbers of swap: 3
//    Array 2:
//    Input array: [136879, 653803, 168639, 374079, 402875]
//    After loop 1: [136879, 653803, 168639, 374079, 402875]
//    After loop 2: [136879, 168639, 653803, 374079, 402875]
//    After loop 3: [136879, 168639, 374079, 653803, 402875]
//    After loop 4: [136879, 168639, 374079, 402875, 653803]
//    Array after sort: [136879, 168639, 374079, 402875, 653803]
//    Numbers of comparison: 10
//    Numbers of swap: 3
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Insertion Sort:
//    Array 1:
//    Input array: [2, 6, 3, 5, 1]
//    After loop 1: [2, 6, 3, 5, 1]
//    After loop 2: [2, 3, 6, 5, 1]
//    After loop 3: [2, 3, 5, 6, 1]
//    After loop 4: [1, 2, 3, 5, 6]
//    Array after sort: [1, 2, 3, 5, 6]
//    Numbers of comparison: 9
//    Numbers of swap: 6
//    Array 2:
//    Input array: [136879, 653803, 168639, 374079, 402875]
//    After loop 1: [136879, 653803, 168639, 374079, 402875]
//    After loop 2: [136879, 168639, 653803, 374079, 402875]
//    After loop 3: [136879, 168639, 374079, 653803, 402875]
//    After loop 4: [136879, 168639, 374079, 402875, 653803]
//    Array after sort: [136879, 168639, 374079, 402875, 653803]
//    Numbers of comparison: 7
//    Numbers of swap: 3
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Merge Sort:
//    Array 1:
//    Input array: [2, 6, 3, 5, 1]
//    After sort array[0,0]: [2, 6, 3, 5, 1]
//    After sort array[1,1]: [2, 6, 3, 5, 1]
//    After merge array[0,1]: [2, 6, 3, 5, 1]
//    After sort array[0,1]: [2, 6, 3, 5, 1]
//    After sort array[2,2]: [2, 6, 3, 5, 1]
//    After merge array[0,2]: [2, 3, 6, 5, 1]
//    After sort array[0,2]: [2, 3, 6, 5, 1]
//    After sort array[3,3]: [2, 3, 6, 5, 1]
//    After sort array[4,4]: [2, 3, 6, 5, 1]
//    After merge array[3,4]: [2, 3, 6, 1, 5]
//    After sort array[3,4]: [2, 3, 6, 1, 5]
//    After merge array[0,4]: [1, 2, 3, 5, 6]
//    Array after sort: [1, 2, 3, 5, 6]
//    Numbers of comparison: 8
//    Array 2:
//    Input array: [136879, 653803, 168639, 374079, 402875]
//    After sort array[0,0]: [136879, 653803, 168639, 374079, 402875]
//    After sort array[1,1]: [136879, 653803, 168639, 374079, 402875]
//    After merge array[0,1]: [136879, 653803, 168639, 374079, 402875]
//    After sort array[0,1]: [136879, 653803, 168639, 374079, 402875]
//    After sort array[2,2]: [136879, 653803, 168639, 374079, 402875]
//    After merge array[0,2]: [136879, 168639, 653803, 374079, 402875]
//    After sort array[0,2]: [136879, 168639, 653803, 374079, 402875]
//    After sort array[3,3]: [136879, 168639, 653803, 374079, 402875]
//    After sort array[4,4]: [136879, 168639, 653803, 374079, 402875]
//    After merge array[3,4]: [136879, 168639, 653803, 374079, 402875]
//    After sort array[3,4]: [136879, 168639, 653803, 374079, 402875]
//    After merge array[0,4]: [136879, 168639, 374079, 402875, 653803]
//    Array after sort: [136879, 168639, 374079, 402875, 653803]
//    Numbers of comparison: 16
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Quick Sort:
//    Array 1:
//    Input array: [2, 6, 3, 5, 1]
//    After partition array[0, 4]: [1, 2, 3, 5, 6]
//    After partition array[2, 4]: [1, 2, 3, 5, 6]
//    After partition array[3, 4]: [1, 2, 3, 5, 6]
//    Array after sort: [1, 2, 3, 5, 6]
//    Numbers of comparison: 7
//    Numbers of swap: 4
//    Array 2:
//    Input array: [136879, 653803, 168639, 374079, 402875]
//    After partition array[0, 4]: [136879, 653803, 168639, 374079, 402875]
//    After partition array[1, 4]: [136879, 402875, 168639, 374079, 653803]
//    After partition array[1, 3]: [136879, 374079, 168639, 402875, 653803]
//    After partition array[1, 2]: [136879, 168639, 374079, 402875, 653803]
//    Array after sort: [136879, 168639, 374079, 402875, 653803]
//    Numbers of comparison: 17
//    Numbers of swap: 14
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Sort time...
//    N = 100
//    Bubble Sort: 0.050000ms
//    Selection Sort: 0.000000ms
//    Insertion Sort: 0.000000ms
//    Merge Sort: 0.000000ms
//    Quick Sort: 0.050000ms
//    N = 1000
//    Bubble Sort: 0.400000ms
//    Selection Sort: 0.800000ms
//    Insertion Sort: 0.050000ms
//    Merge Sort: 0.000000ms
//    Quick Sort: 0.600000ms
//    N = 10000
//    Bubble Sort: 95.650000ms
//    Selection Sort: 18.350000ms
//    Insertion Sort: 6.250000ms
//    Merge Sort: 0.800000ms
//    Quick Sort: 0.750000ms
//    N = 100000
//    Bubble Sort: 13900.200000ms
//    Selection Sort: 1985.700000ms
//    Insertion Sort: 631.200000ms
//    Merge Sort: 10.750000ms
//    Quick Sort: 6.950000ms
}