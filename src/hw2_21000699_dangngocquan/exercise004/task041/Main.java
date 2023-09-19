package hw2_21000699_dangngocquan.exercise004.task041;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        scanner.close();

        BubbleSort.sort(a);

        for (int e : a) System.out.print(e + " ");
    }

    private static class BubbleSort {
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
}
