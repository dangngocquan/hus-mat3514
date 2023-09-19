package hw2_21000699_dangngocquan.exercise004.task043;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        scanner.close();

        SelectionSort.sort(a);

        for (int e : a) System.out.print(e + " ");
    }

    private static class SelectionSort {
        public static <T extends Comparable<T>> void sort(T[] a) {
            for (int i = 0; i < a.length-1; i++) {
                int indexOfMinValue = i;
                for (int j = i+1; j < a.length; j++) {
                    if (a[j].compareTo(a[indexOfMinValue]) < 0) {
                        indexOfMinValue = j;
                    }
                }
                if (indexOfMinValue != i) {
                    T temp = a[indexOfMinValue];
                    a[indexOfMinValue] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
