package hw2_21000699_dangngocquan.exercise002.service.sort;

public class Sort {
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        int[] data = BubbleSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int[] data = SelectionSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int[] data = InsertionSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] a) {
        int[] data = MergeSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static <T extends Comparable<T>> void quickSort(T[] a) {
        int[] data = QuickSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }
}
