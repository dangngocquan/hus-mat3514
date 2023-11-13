package hw6_21000699_dangngocquan.exercise003;


import hw6_21000699_dangngocquan.exercise003.sort.*;

public class TimeSort<T extends Comparable<T>> {
    public long msBubbleSort(T[] array) {
        long start = System.currentTimeMillis();
        new BubbleSort().sort(array);
        return System.currentTimeMillis() - start;
    }

    public long msSelectionSort(T[] array) {
        long start = System.currentTimeMillis();
        new SelectionSort().sort(array);
        return System.currentTimeMillis() - start;
    }

    public long msInsertionSort(T[] array) {
        long start = System.currentTimeMillis();
        new InsertionSort().sort(array);
        return System.currentTimeMillis() - start;
    }

    public long msQuickSort(T[] array) {
        long start = System.currentTimeMillis();
        new QuickSort().sort(array);
        return System.currentTimeMillis() - start;
    }

    public long msMergeSort(T[] array) {
        long start = System.currentTimeMillis();
        new MergeSort().sort(array);
        return System.currentTimeMillis() - start;
    }

    public long msHeapSort(T[] array) {
        long start = System.currentTimeMillis();
        new HeapSort().sort(array);
        return System.currentTimeMillis() - start;
    }
}
