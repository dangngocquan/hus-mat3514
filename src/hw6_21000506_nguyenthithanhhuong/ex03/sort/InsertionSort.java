package hw6_21000506_nguyenthithanhhuong.ex03.sort;

public class InsertionSort {
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0) {
                if (array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
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
