package hw2_22001273_nguyenhoangminh.excercise5;

import hw2_22001273_nguyenhoangminh.excercise1.Sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sorting n integer in array.");
        System.out.println("Input integer n: ");
        int length = input.nextInt();
        System.out.println("Nhap vao " + length + " so nguyen cua day:");
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = input.nextInt();
        }
        Sort.bubbleSort2(array, length);
        for (int i=0; i<length; ++i) {
            System.out.print(array[i] + " ");
        }
        input.close();
    }
}
