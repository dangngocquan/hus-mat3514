package hw2_21000676_damhaidang.ex1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong phan tu: ");
        int length = sc.nextInt();

        Sort bubbleSort = new BubbleSort();
        ((BubbleSort) bubbleSort).test(length);

        Sort insertionSort = new InsertionSort();
        ((InsertionSort) insertionSort).test(length);

        Sort selectionSort = new SelectionSort();
        ((SelectionSort) selectionSort).test(length);

        Sort quickSort = new QuickSort();
        ((QuickSort) quickSort).test(length);

        Sort mergeSort = new MergeSort();
        ((MergeSort) mergeSort).test(length);
    }
}
