package hw2_21000506_nguyenthithanhhuong.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define length of array read by keyboard
        System.out.println("Enter the length of array (keyboard): ");
        int length1 = sc.nextInt();

        Integer[] array1 = new Integer[length1];

        // Read elements of an array by keyboard
        System.out.println("Enter elements of array by keyboard: ");
        CreateArray.createIntegerArrayByKeyboard(sc, array1);

        // Define length of array random
        System.out.println("Enter the length of array (random): ");
        int length2 = sc.nextInt();
        sc.close();

        // Create array random
        Integer[] array2 = new Integer[length2];
        CreateArray.createIntegerRandomArray(array2);

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
        BubbleSort.bubbleSort(Arrays.copyOfRange(array2, 0, array1.length));

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
        Integer[] arrTest1 = new Integer[100];
        CreateArray.createIntegerRandomArray(arrTest1);

        // Create random array with N = 1000
        Integer[] arrTest2 = new Integer[1000];
        CreateArray.createIntegerRandomArray(arrTest2);

        // Create random array with N = 10000
        Integer[] arrTest3 = new Integer[10000];
        CreateArray.createIntegerRandomArray(arrTest3);

        // Create random array with N = 100000
        Integer[] arrTest4 = new Integer[100000];
        CreateArray.createIntegerRandomArray(arrTest4);

        TimeSort.timeSort(arrTest1);
        TimeSort.timeSort(arrTest2);
        TimeSort.timeSort(arrTest3);
        TimeSort.timeSort(arrTest4);
    }

//    Enter the length of array (keyboard):
//    6
//    Enter elements of array by keyboard:
//    3 6 9 8 4 1
//    Enter the length of array (random):
//    6
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Array read by keyboard:
//    [3, 6, 9, 8, 4, 1]
//    Array random:
//    [987410, 881676, 810631, 396025, 244225, 565500]
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Bubble Sort:
//    Array 1:
//    Input array: [3, 6, 9, 8, 4, 1]
//    After loop 1: [3, 6, 8, 4, 1, 9]
//    After loop 2: [3, 6, 4, 1, 8, 9]
//    After loop 3: [3, 4, 1, 6, 8, 9]
//    After loop 4: [3, 1, 4, 6, 8, 9]
//    After loop 5: [1, 3, 4, 6, 8, 9]
//    Array after sort: [1, 3, 4, 6, 8, 9]
//    Numbers of comparison: 15
//    Numbers of swap: 9
//    Array 2:
//    Input array: [987410, 881676, 810631, 396025, 244225, 565500]
//    After loop 1: [881676, 810631, 396025, 244225, 565500, 987410]
//    After loop 2: [810631, 396025, 244225, 565500, 881676, 987410]
//    After loop 3: [396025, 244225, 565500, 810631, 881676, 987410]
//    After loop 4: [244225, 396025, 565500, 810631, 881676, 987410]
//    Array after sort: [244225, 396025, 565500, 810631, 881676, 987410]
//    Numbers of comparison: 15
//    Numbers of swap: 13
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Selection Sort:
//    Array 1:
//    Input array: [3, 6, 9, 8, 4, 1]
//    After loop 1: [1, 6, 9, 8, 4, 3]
//    After loop 2: [1, 3, 9, 8, 4, 6]
//    After loop 3: [1, 3, 4, 8, 9, 6]
//    After loop 4: [1, 3, 4, 6, 9, 8]
//    After loop 5: [1, 3, 4, 6, 8, 9]
//    Array after sort: [1, 3, 4, 6, 8, 9]
//    Numbers of comparison: 15
//    Numbers of swap: 7
//    Array 2:
//    Input array: [987410, 881676, 810631, 396025, 244225, 565500]
//    After loop 1: [244225, 881676, 810631, 396025, 987410, 565500]
//    After loop 2: [244225, 396025, 810631, 881676, 987410, 565500]
//    After loop 3: [244225, 396025, 565500, 881676, 987410, 810631]
//    After loop 4: [244225, 396025, 565500, 810631, 987410, 881676]
//    After loop 5: [244225, 396025, 565500, 810631, 881676, 987410]
//    Array after sort: [244225, 396025, 565500, 810631, 881676, 987410]
//    Numbers of comparison: 15
//    Numbers of swap: 9
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Insertion Sort:
//    Array 1:
//    Input array: [3, 6, 9, 8, 4, 1]
//    After loop 1: [3, 6, 9, 8, 4, 1]
//    After loop 2: [3, 6, 9, 8, 4, 1]
//    After loop 3: [3, 6, 8, 9, 4, 1]
//    After loop 4: [3, 4, 6, 8, 9, 1]
//    After loop 5: [1, 3, 4, 6, 8, 9]
//    Array after sort: [1, 3, 4, 6, 8, 9]
//    Numbers of comparison: 13
//    Numbers of swap: 9
//    Array 2:
//    Input array: [987410, 881676, 810631, 396025, 244225, 565500]
//    After loop 1: [881676, 987410, 810631, 396025, 244225, 565500]
//    After loop 2: [810631, 881676, 987410, 396025, 244225, 565500]
//    After loop 3: [396025, 810631, 881676, 987410, 244225, 565500]
//    After loop 4: [244225, 396025, 810631, 881676, 987410, 565500]
//    After loop 5: [244225, 396025, 565500, 810631, 881676, 987410]
//    Array after sort: [244225, 396025, 565500, 810631, 881676, 987410]
//    Numbers of comparison: 14
//    Numbers of swap: 13
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Merge Sort:
//    Array 1:
//    Input array: [3, 6, 9, 8, 4, 1]
//    After sort array[0,0]: [3, 6, 9, 8, 4, 1]
//    After sort array[1,1]: [3, 6, 9, 8, 4, 1]
//    After merge array[0,1]: [3, 6, 9, 8, 4, 1]
//    After sort array[0,1]: [3, 6, 9, 8, 4, 1]
//    After sort array[2,2]: [3, 6, 9, 8, 4, 1]
//    After merge array[0,2]: [3, 6, 9, 8, 4, 1]
//    After sort array[0,2]: [3, 6, 9, 8, 4, 1]
//    After sort array[3,3]: [3, 6, 9, 8, 4, 1]
//    After sort array[4,4]: [3, 6, 9, 8, 4, 1]
//    After merge array[3,4]: [3, 6, 9, 4, 8, 1]
//    After sort array[3,4]: [3, 6, 9, 4, 8, 1]
//    After sort array[5,5]: [3, 6, 9, 4, 8, 1]
//    After merge array[3,5]: [3, 6, 9, 1, 4, 8]
//    After sort array[3,5]: [3, 6, 9, 1, 4, 8]
//    After merge array[0,5]: [1, 3, 4, 6, 8, 9]
//    Array after sort: [1, 3, 4, 6, 8, 9]
//    Numbers of comparison: 10
//    Array 2:
//    Input array: [987410, 881676, 810631, 396025, 244225, 565500]
//    After sort array[0,0]: [987410, 881676, 810631, 396025, 244225, 565500]
//    After sort array[1,1]: [987410, 881676, 810631, 396025, 244225, 565500]
//    After merge array[0,1]: [881676, 987410, 810631, 396025, 244225, 565500]
//    After sort array[0,1]: [881676, 987410, 810631, 396025, 244225, 565500]
//    After sort array[2,2]: [881676, 987410, 810631, 396025, 244225, 565500]
//    After merge array[0,2]: [810631, 881676, 987410, 396025, 244225, 565500]
//    After sort array[0,2]: [810631, 881676, 987410, 396025, 244225, 565500]
//    After sort array[3,3]: [810631, 881676, 987410, 396025, 244225, 565500]
//    After sort array[4,4]: [810631, 881676, 987410, 396025, 244225, 565500]
//    After merge array[3,4]: [810631, 881676, 987410, 244225, 396025, 565500]
//    After sort array[3,4]: [810631, 881676, 987410, 244225, 396025, 565500]
//    After sort array[5,5]: [810631, 881676, 987410, 244225, 396025, 565500]
//    After merge array[3,5]: [810631, 881676, 987410, 244225, 396025, 565500]
//    After sort array[3,5]: [810631, 881676, 987410, 244225, 396025, 565500]
//    After merge array[0,5]: [244225, 396025, 565500, 810631, 881676, 987410]
//    Array after sort: [244225, 396025, 565500, 810631, 881676, 987410]
//    Numbers of comparison: 18
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Quick Sort:
//    Array 1:
//    Input array: [3, 6, 9, 8, 4, 1]
//    After partition array[0, 5]: [1, 3, 9, 8, 4, 6]
//    After partition array[2, 5]: [1, 3, 6, 8, 4, 9]
//    After partition array[2, 4]: [1, 3, 4, 6, 8, 9]
//    Array after sort: [1, 3, 4, 6, 8, 9]
//    Numbers of comparison: 10
//    Numbers of swap: 8
//    Array 2:
//    Input array: [987410, 881676, 810631, 396025, 244225, 565500]
//    After partition array[0, 5]: [565500, 881676, 810631, 396025, 244225, 987410]
//    After partition array[0, 4]: [244225, 396025, 565500, 881676, 810631, 987410]
//    After partition array[0, 1]: [244225, 396025, 565500, 881676, 810631, 987410]
//    After partition array[3, 4]: [244225, 396025, 565500, 810631, 881676, 987410]
//    Array after sort: [244225, 396025, 565500, 810631, 881676, 987410]
//    Numbers of comparison: 21
//    Numbers of swap: 20
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    Sort time...
//    N = 100
//    Bubble Sort: 0.000000ms
//    Selection Sort: 0.000000ms
//    Insertion Sort: 0.800000ms
//    Merge Sort: 0.000000ms
//    Quick Sort: 0.000000ms
//    N = 1000
//    Bubble Sort: 3.300000ms
//    Selection Sort: 2.550000ms
//    Insertion Sort: 3.450000ms
//    Merge Sort: 1.500000ms
//    Quick Sort: 0.050000ms
//    N = 10000
//    Bubble Sort: 190.350000ms
//    Selection Sort: 156.950000ms
//    Insertion Sort: 62.750000ms
//    Merge Sort: 7.900000ms
//    Quick Sort: 2.350000ms
//    N = 100000
//    Bubble Sort: 32738.600000ms
//    Selection Sort: 15777.700000ms
//    Insertion Sort: 7286.150000ms
//    Merge Sort: 26.150000ms
//    Quick Sort: 18.100000ms
}
