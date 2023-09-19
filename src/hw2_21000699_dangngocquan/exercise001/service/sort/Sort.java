package hw2_21000699_dangngocquan.exercise001.service.sort;

public class Sort {
    public static void bubbleSort(int[] a) {
        int[] data = BubbleSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static void selectionSort(int[] a) {
        int[] data = SelectionSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static void insertionSort(int[] a) {
        int[] data = InsertionSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static void mergeSort(int[] a) {
        int[] data = MergeSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }

    public static void quickSort(int[] a) {
        int[] data = QuickSort.sort(a);
        System.out.printf("Number compare elements: %d\n", data[0]);
        System.out.printf("Number swap elements: %d\n", data[1]);
    }
}
