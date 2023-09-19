package hw2_21000699_dangngocquan.exercise007;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer x = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        scanner.close();

        int count = 0;
        MergeSort.sort(a);
        for (int i = 1; i < n; i++) {
            int i1 = BinarySearch.firstIndexOf(x - a[i], a, 0, i-1);
            if (i1 > -1) {
                int i2 = BinarySearch.lastIndexOf(x - a[i], a, 0, i-1);
                count += i2 - i1 + 1;
            }
        }

        System.out.println(count);
    }

    private static class MergeSort {
        public static <T extends Comparable<T>> void sort(T[] a) {
            mergeSort(a, 0, a.length-1);
        }

        // Sort a[left, right]
        private static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(a, left, mid);
                mergeSort(a, mid + 1, right);
                merge(a, left, mid, right);
            }
        }

        // merge two sorted sub-array a[left, mid] and a[mid+1, right]
        private static <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right) {
            int bLength = right - left + 1;
            T[] b = Arrays.copyOf(a, bLength);
            int i = 0;
            int i1 = left;
            int i2 = mid+1;
            while (i1 <= mid && i2 <= right) {
                if (a[i1].compareTo(a[i2]) <= 0) {
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

    private static class BinarySearch {
        public static <T extends Comparable<T>> int firstIndexOf(T value, T[] sortedArray, int left, int right) {
            if (left > right) return -1;
            int mid = (left + right) / 2;
            if (value.compareTo(sortedArray[mid]) == 0) {
                int firstIndex = firstIndexOf(value, sortedArray, left, mid - 1);
                if (firstIndex == -1) return mid;
                return firstIndex;
            } else if (value.compareTo(sortedArray[mid]) > 0) {
                return firstIndexOf(value, sortedArray, mid + 1, right);
            } else {
                return firstIndexOf(value, sortedArray, left, mid - 1);
            }
        }

        public static <T extends Comparable<T>> int lastIndexOf(T value, T[] sortedArray, int left, int right) {
            if (left > right) return -1;
            int mid = (left + right) / 2;
            if (value.compareTo(sortedArray[mid]) == 0) {
                int lastIndex = lastIndexOf(value, sortedArray, mid+1, right);
                if (lastIndex == -1) return mid;
                return lastIndex;
            } else if (value.compareTo(sortedArray[mid]) > 0) {
                return lastIndexOf(value, sortedArray, mid + 1, right);
            } else {
                return lastIndexOf(value, sortedArray, left, mid - 1);
            }
        }
    }
}
