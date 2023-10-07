package hw2_22001273_nguyenhoangminh.excercise6;

import java.util.Scanner;

import hw2_22001273_nguyenhoangminh.excercise1.Sort;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Tim so nho thu k trong day n so nguyen");
        System.out.println("Input integer n and k ");
        int length = input.nextInt();
        int index = input.nextInt();
        System.out.println("Nhap vao " + length + " so nguyen cua day:");
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = input.nextInt();
        }
        Sort.bubbleSort2(array, length);
        System.out.println("Day so sau khi sap xep la:");
        for (int i=0; i<length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("So nho thu k la: " + array[index-1]);
        input.close();
    }
}
