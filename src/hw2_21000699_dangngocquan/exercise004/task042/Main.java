package hw2_21000699_dangngocquan.exercise004.task042;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        scanner.close();

        InsertionSort.sort(a);

        for (int e : a) System.out.print(e + " ");
    }

    private static class InsertionSort {
        public static <T extends Comparable<T>> void sort(T[] a) {
            for (int i = 1; i < a.length; i++) {
                T valueInsert = a[i];
                int j = i - 1;
                while (j >= 0) {
                    if (a[j].compareTo(valueInsert) > 0) {
                        a[j + 1] = a[j];
                        j--;
                    } else {
                        break;
                    }
                }
                a[j + 1] = valueInsert;
            }
        }
    }
}
