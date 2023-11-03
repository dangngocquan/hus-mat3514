package hw6_21000699_dangngocquan.exercise003.sort;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length-1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < a.length-i; j++) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    isSorted = false;
                    T temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            if (isSorted) break;
        }
    }
}
