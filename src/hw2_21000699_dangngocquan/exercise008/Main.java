package hw2_21000699_dangngocquan.exercise008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        String sortedS = sortStringDigit(s);
        System.out.println(sortedS);

        int[] count = new int[10];
        for (int i = 0; i < sortedS.length(); i++) count[sortedS.charAt(i) - '0']++;
        for (int i = 0; i < 10; i++) System.out.printf("count[%d] = %d\n", i, count[i]);
    }

    public static String sortStringDigit(String s) {
        String[] chars = s.split("");
        InsertionSort.sort(chars);
        return String.join("", chars);
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
