package hw2_21000699_dangngocquan.exercise002.service.sort;

public class TimeSort {
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        long time = BubbleSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        long time = SelectionSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        long time = InsertionSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] a) {
        long time = MergeSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }

    public static <T extends Comparable<T>> void quickSort(T[] a) {
        long time = QuickSort.timeSort(a);
        System.out.printf("Time: %dms\n", time);
    }
}
