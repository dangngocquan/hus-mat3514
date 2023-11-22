package hw6_21000506_nguyenthithanhhuong.ex03.sort.test_sort;

import hw6_21000506_nguyenthithanhhuong.ex03.sort.*;
import hw6_21000506_nguyenthithanhhuong.ex03.sort.test_sort.ArrayTest;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] arrTest = new Integer[6];
        ArrayTest.createRandomArray(arrTest);

        System.out.println("Origin array: ");
        System.out.println(ArrayTest.printArray(arrTest));

        System.out.println("1. Bubble Sort: ");
        Integer[] bubbleArr = BubbleSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(bubbleArr));

        System.out.println("2. Selection Sort: ");
        Integer[] selectionArr = SelectionSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(selectionArr));

        System.out.println("3. Insertion Sort: ");
        Integer[] insertionArr = InsertionSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(insertionArr));

        System.out.println("4. Merge Sort: ");
        Integer[] mergeArr = MergeSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(mergeArr));

        System.out.println("5. Quick sort: ");
        Integer[] quickArr = QuickSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(quickArr));

        System.out.println("6. Heap Sort: ");
        Integer[] heapArr = HeapSort.sort(Arrays.copyOfRange(arrTest, 0, arrTest.length));
        System.out.println(ArrayTest.printArray(heapArr));
    }
}

//    Origin array:
//    [38, 97, 432, 103, 44, 761]
//    1. Bubble Sort:
//    [38, 44, 97, 103, 432, 761]
//    2. Selection Sort:
//    [38, 44, 97, 103, 432, 761]
//    3. Insertion Sort:
//    [38, 44, 97, 103, 432, 761]
//    4. Merge Sort:
//    [38, 44, 97, 103, 432, 761]
//    5. Quick sort:
//    [38, 44, 97, 103, 432, 761]
//    6. Heap Sort:
//    [38, 44, 97, 103, 432, 761]
