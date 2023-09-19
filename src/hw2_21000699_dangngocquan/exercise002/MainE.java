package hw2_21000699_dangngocquan.exercise002;

import hw2_21000699_dangngocquan.exercise002.service.generator.Generator;
import hw2_21000699_dangngocquan.exercise002.service.sort.TimeSort;

public class MainE {
    public static void main(String[] args) {
        int[] n = new int[] {100, 1000, 10000, 100000};

        for (int i = 0; i < n.length; i++) {
            System.out.printf("N = %d\n", n[i]);
            Integer[] a = Generator.randomArray(n[i], 1, 1000001);
            System.out.print("1. Bubble sort: ");
            TimeSort.bubbleSort(a.clone());
            System.out.print("2. Selection sort: ");
            TimeSort.selectionSort(a.clone());
            System.out.print("3. Insertion sort: ");
            TimeSort.insertionSort(a.clone());
            System.out.print("4. Merge sort: ");
            TimeSort.mergeSort(a.clone());
            System.out.print("5. Quick sort: ");
            TimeSort.quickSort(a.clone());
            System.out.println();
        }

        // N = 100
        // 1. Bubble sort: Time: 0ms
        // 2. Selection sort: Time: 0ms
        // 3. Insertion sort: Time: 0ms
        // 4. Merge sort: Time: 0ms
        // 5. Quick sort: Time: 0ms
        //
        // N = 1000
        // 1. Bubble sort: Time: 10ms
        // 2. Selection sort: Time: 0ms
        // 3. Insertion sort: Time: 0ms
        // 4. Merge sort: Time: 0ms
        // 5. Quick sort: Time: 0ms
        //
        // N = 10000
        // 1. Bubble sort: Time: 62ms
        // 2. Selection sort: Time: 38ms
        // 3. Insertion sort: Time: 0ms
        // 4. Merge sort: Time: 0ms
        // 5. Quick sort: Time: 0ms
        //
        // N = 100000
        // 1. Bubble sort: Time: 12878ms
        // 2. Selection sort: Time: 2112ms
        // 3. Insertion sort: Time: 565ms
        // 4. Merge sort: Time: 6ms
        // 5. Quick sort: Time: 10ms

        // Low to Fast
        // BubbleSort --> SelectionSort --> InsertionSort --> QuickSort --> MergeSort
    }
}
