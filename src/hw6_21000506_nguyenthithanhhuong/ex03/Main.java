package hw6_21000506_nguyenthithanhhuong.ex03;

import hw6_21000506_nguyenthithanhhuong.ex03.sort.test_sort.ArrayTest;
import hw6_21000506_nguyenthithanhhuong.ex03.time.TimeSort;

public class Main {
    public static void main(String[] args) {
        // Create random array with N = 100
        Integer[] arrTest1 = new Integer[100];
        ArrayTest.createRandomArray(arrTest1);

        // Create random array with N = 1000
        Integer[] arrTest2 = new Integer[1000];
        ArrayTest.createRandomArray(arrTest2);

        // Create random array with N = 10000
        Integer[] arrTest3 = new Integer[10000];
        ArrayTest.createRandomArray(arrTest3);

        // Create random array with N = 20000
        Integer[] arrTest4 = new Integer[20000];
        ArrayTest.createRandomArray(arrTest4);

        // Create random array with N = 30000
        Integer[] arrTest5 = new Integer[30000];
        ArrayTest.createRandomArray(arrTest5);

        // Create random array with N = 40000
        Integer[] arrTest6 = new Integer[40000];
        ArrayTest.createRandomArray(arrTest6);

        // Create random array with N = 50000
        Integer[] arrTest7 = new Integer[50000];
        ArrayTest.createRandomArray(arrTest7);

        // Create random array with N = 60000
        Integer[] arrTest8 = new Integer[60000];
        ArrayTest.createRandomArray(arrTest8);

        // Create random array with N = 80000
        Integer[] arrTest9 = new Integer[80000];
        ArrayTest.createRandomArray(arrTest9);

        // Create random array with N = 100000
        Integer[] arrTest10 = new Integer[100000];
        ArrayTest.createRandomArray(arrTest10);

        TimeSort.timeSort(arrTest1);
        TimeSort.timeSort(arrTest2);
        TimeSort.timeSort(arrTest3);
        TimeSort.timeSort(arrTest4);
        TimeSort.timeSort(arrTest5);
        TimeSort.timeSort(arrTest6);
        TimeSort.timeSort(arrTest7);
        TimeSort.timeSort(arrTest8);
        TimeSort.timeSort(arrTest9);
        TimeSort.timeSort(arrTest10);
    }
}

//    N = 100
//    Bubble Sort: 0.750000ms
//    Selection Sort: 0.000000ms
//    Insertion Sort: 0.000000ms
//    Merge Sort: 0.800000ms
//    Quick Sort: 0.100000ms
//    Heap Sort: 0.000000ms
//    N = 1000
//    Bubble Sort: 5.450000ms
//    Selection Sort: 3.400000ms
//    Insertion Sort: 2.400000ms
//    Merge Sort: 0.800000ms
//    Quick Sort: 0.750000ms
//    Heap Sort: 0.800000ms
//    N = 10000
//    Bubble Sort: 283.950000ms
//    Selection Sort: 160.500000ms
//    Insertion Sort: 65.200000ms
//    Merge Sort: 7.800000ms
//    Quick Sort: 2.350000ms
//    Heap Sort: 2.350000ms
//    N = 20000
//    Bubble Sort: 1042.650000ms
//    Selection Sort: 629.350000ms
//    Insertion Sort: 260.850000ms
//    Merge Sort: 8.600000ms
//    Quick Sort: 1.550000ms
//    Heap Sort: 6.250000ms
//    N = 30000
//    Bubble Sort: 2376.750000ms
//    Selection Sort: 1415.000000ms
//    Insertion Sort: 603.450000ms
//    Merge Sort: 12.100000ms
//    Quick Sort: 3.100000ms
//    Heap Sort: 6.300000ms
//    N = 40000
//    Bubble Sort: 4197.100000ms
//    Selection Sort: 2916.400000ms
//    Insertion Sort: 1088.450000ms
//    Merge Sort: 7.800000ms
//    Quick Sort: 3.900000ms
//    Heap Sort: 9.100000ms
//    N = 50000
//    Bubble Sort: 6854.500000ms
//    Selection Sort: 3189.400000ms
//    Insertion Sort: 1775.700000ms
//    Merge Sort: 9.550000ms
//    Quick Sort: 6.250000ms
//    Heap Sort: 12.500000ms
//    N = 60000
//    Bubble Sort: 9431.000000ms
//    Selection Sort: 3836.450000ms
//    Insertion Sort: 2299.350000ms
//    Merge Sort: 24.300000ms
//    Quick Sort: 7.050000ms
//    Heap Sort: 16.450000ms
//    N = 80000
//    Bubble Sort: 17826.300000ms
//    Selection Sort: 5530.050000ms
//    Insertion Sort: 4713.750000ms
//    Merge Sort: 40.850000ms
//    Quick Sort: 10.950000ms
//    Heap Sort: 25.200000ms
//    N = 100000
//    Bubble Sort: 27029.500000ms
//    Selection Sort: 9851.400000ms
//    Insertion Sort: 7986.450000ms
//    Merge Sort: 64.150000ms
//    Quick Sort: 17.000000ms
//    Heap Sort: 41.950000ms