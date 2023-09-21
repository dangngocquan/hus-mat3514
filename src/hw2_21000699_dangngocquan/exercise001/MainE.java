package hw2_21000699_dangngocquan.exercise001;

import hw2_21000699_dangngocquan.exercise001.service.generator.Generator;
import hw2_21000699_dangngocquan.exercise001.service.sort.TimeSort;

public class MainE {
    public static void main(String[] args) {
        int[] n = new int[] {100, 1000, 10000, 100000};
        long[][] times = new long[5][n.length];
        // times[i][j]: Total milliseconds when run algorithm sort i with array length n = n[j]

        int numberTests = 20;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < numberTests; j++) {
                int[] a = Generator.randomArray(n[i], 1, 1000001);
                times[0][i] += TimeSort.bubbleSort(a.clone());
                times[1][i] += TimeSort.selectionSort(a.clone());
                times[2][i] += TimeSort.insertionSort(a.clone());
                times[3][i] += TimeSort.mergeSort(a.clone());
                times[4][i] += TimeSort.quickSort(a.clone());
            }
        }

        for (int i = 0; i < n.length; i++) {
            System.out.printf("N = %d\n", n[i]);
            System.out.printf("1. Bubble sort: %sms\n", times[0][i] * 1.0 / numberTests);
            System.out.printf("2. Selection sort: %sms\n", times[1][i] * 1.0 / numberTests);
            System.out.printf("3. Insertion sort: %sms\n", times[2][i] * 1.0 / numberTests);
            System.out.printf("4. Merge sort: %sms\n", times[3][i] * 1.0 / numberTests);
            System.out.printf("5. Quick sort: %sms\n", times[4][i] * 1.0 / numberTests);
            System.out.println();
        }

        // Output (after 7 minutes waiting for all tests)
        // N = 100
        // 1. Bubble sort: 0.0ms
        // 2. Selection sort: 0.0ms
        // 3. Insertion sort: 0.0ms
        // 4. Merge sort: 0.0ms
        // 5. Quick sort: 0.0ms
        //
        // N = 1000
        // 1. Bubble sort: 0.8ms
        // 2. Selection sort: 0.8ms
        // 3. Insertion sort: 0.0ms
        // 4. Merge sort: 0.0ms
        // 5. Quick sort: 0.0ms
        //
        // N = 10000
        // 1. Bubble sort: 110.9ms
        // 2. Selection sort: 29.5ms
        // 3. Insertion sort: 6.35ms
        // 4. Merge sort: 0.75ms
        // 5. Quick sort: 1.15ms
        //
        // N = 100000
        // 1. Bubble sort: 16155.55ms
        // 2. Selection sort: 2773.0ms
        // 3. Insertion sort: 731.85ms
        // 4. Merge sort: 12.4ms
        // 5. Quick sort: 9.45ms


    }
}
