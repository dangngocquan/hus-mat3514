package hw6_21000506_nguyenthithanhhuong.ex03.sort;

public class SelectionSort {
    public static  <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
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
