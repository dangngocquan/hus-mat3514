package hw6_21000506_nguyenthithanhhuong.ex03.sort;

public class BubbleSort {
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSort = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    T temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) break;
        }
        return array;
    }

    public static <T extends Comparable<T>> long time(T[] array) {
        long start =  System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
