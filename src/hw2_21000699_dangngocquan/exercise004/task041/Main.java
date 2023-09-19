package hw2_21000699_dangngocquan.exercise004.task041;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        scanner.close();

        MergeSort.sort(a);

        for (int e : a) System.out.print(e + " ");
    }

    private static class MergeSort {
        public static void sort(int[] a) {
            mergeSort(a, 0, a.length-1);
        }

        // Sort a[left, right]
        private static void mergeSort(int[] a, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(a, left, mid);
                mergeSort(a, mid + 1, right);
                merge(a, left, mid, right);
            }
        }

        // merge two sorted sub-array a[left, mid] and a[mid+1, right]
        private static void merge(int[] a, int left, int mid, int right) {
            int bLength = right - left + 1;
            int[] b = new int[bLength];
            int i = 0;
            int i1 = left;
            int i2 = mid+1;
            while (i1 <= mid && i2 <= right) {
                if (a[i1] <= a[i2]) {
                    b[i] = a[i1];
                    i1++;
                } else {
                    b[i] = a[i2];
                    i2++;
                }
                i++;
            }
            while (i1 <= mid) b[i++] = a[i1++];
            while (i2 <= right) b[i++] = a[i2++];
            i = 0;
            while (i < bLength) a[i+left] = b[i++];
        }
    }
}
