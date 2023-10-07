package hw2_21000676_damhaidang.ex2;

import java.util.Arrays;
import java.util.Scanner;

class MyArray<T extends Comparable<T>> {
    private T[] array;

    public MyArray(T[] arr) {
        this.array = arr;
    }

    public int size() {
        return array.length;
    }
    public void print() {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // Bubble sort
    public void bubbleSort() {
        int length = array.length;
        T temp;

        for(int idx1 = 0; idx1 < length; idx1++) {
            for(int idx2 = 1; idx2 < (length - idx1); idx2++) {
                if(array[idx2 - 1].compareTo(array[idx2]) > 0) {
                    temp = array[idx2 - 1];
                    array[idx2 - 1] = array[idx2];
                    array[idx2] = temp;
                }
                print();
            }
        }
    }

    // Insertion sort
    public void insertionSort() {
        int length = array.length;
        for (int idx1 = 1; idx1 < length; ++idx1) {
            T key = array[idx1];
            int idx2 = idx1 - 1;

            while (idx2 >= 0 && array[idx2].compareTo(key) > 0) {
                array[idx2 + 1] = array[idx2];
                idx2 = idx2 - 1;
                print();
            }
            array[idx2 + 1] = key;
            print();
        }
    }

    // Selection sort
    public void selectionSort() {
        int n = array.length;
        for (int idx1 = 0; idx1 < n - 1; idx1++) {
            int minIndex = idx1;
            for (int idx2 = idx1 + 1; idx2 < n; idx2++) {
                if (array[idx2].compareTo(array[minIndex]) < 0) {
                    minIndex = idx2;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[idx1];
            array[idx1] = temp;
            print();
        }
    }

    // Quick Sort
    private int partitioning(T[] arr, int start, int end) {
        T pivot = arr[end];
        int balancePoint = start;

        for (int idx1 = start; idx1 < end; idx1++) {
            if (arr[idx1].compareTo(pivot) <= 0) {
                T temp = arr[idx1];
                arr[idx1] = arr[balancePoint];
                arr[balancePoint] = temp;
                balancePoint++;
                print();
            }
        }

        T temp = arr[end];
        arr[end] = arr[balancePoint];
        arr[balancePoint] = temp;
        print();
        return balancePoint;
    }

    public void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partitioning(array, start, end);

        quickSort(start, pivot - 1);
        quickSort(pivot + 1, end);
    }

    // Merge sort
    public void mergeSort() {
        sort(array);
    }

    public void sort(T[] array) {
        if (array.length > 1) {
            T[] firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
            T[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

            sort(firstHalf);
            sort(secondHalf);

            merge(firstHalf, secondHalf, array);
        }
    }

    public void merge(T[] firstHalf, T[] secondHalf, T[] result) {
        int current1 = 0; // Current index in firstHalf
        int current2 = 0; // Current index in secondHalf
        int current3 = 0; // Current index in result

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (firstHalf[current1].compareTo(secondHalf[current2]) < 0)
                result[current3++] = firstHalf[current1++];
            else
                result[current3++] = secondHalf[current2++];
        }

        while (current1 < firstHalf.length)
            result[current3++] = firstHalf[current1++];

        while (current2 < secondHalf.length)
            result[current3++] = secondHalf[current2++];
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so luong phan tu cua mang: ");
        int length = scanner.nextInt();
        long bubble = 0, insertion = 0, selection = 0, quick = 0, merge = 0;

        for (int i = 0; i < 20; i++) {
            long start = System.nanoTime();
            MyArray<Integer> array = new MyArray<>(generateArray(length));
            array.bubbleSort();
            long sort1 = System.nanoTime();
            bubble += sort1 - start;

            MyArray<Integer> array2 = new MyArray<>(generateArray(length));
            array2.insertionSort();
            long sort2 = System.nanoTime();
            insertion += sort2 - sort1;

            MyArray<Integer> array3 = new MyArray<>(generateArray(length));
            array3.selectionSort();
            long sort3 = System.nanoTime();
            selection += sort3 - sort2;

            MyArray<Integer> array4 = new MyArray<>(generateArray(length));
            array4.quickSort(0, array4.size() - 1);
            long sort4 = System.nanoTime();
            quick += sort4 - sort3;

            MyArray<Integer> array5 = new MyArray<>(generateArray(length));
            array5.mergeSort();
            long sort5 = System.nanoTime();
            merge += sort5 - sort4;
        }

        System.out.println("Thoi gian chay: \n" +
                "- BubbleSort: " + bubble / 20 + " nanoseconds\n" +
                "- InsertionSort: " + insertion / 20 + " nanoseconds\n" +
                "- SelectionSort: " + selection / 20 + " nanoseconds\n" +
                "- QuickSort: " + quick / 20 + " nanoseconds\n" +
                "- MergeSort: " + merge / 20 + " nanoseconds" );
    }

    public static Integer[] generateArray(int length) {
        Integer[] array = new Integer[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * Math.pow(10, 6)) + 1;
        }
        return array;
    }
}
