package hw2_22001273_nguyenhoangminh.excercise47;

import java.util.Scanner;

import hw2_22001273_nguyenhoangminh.excercise1.Sort;

public class Main {
    // Find smallest method
    public static int findSmallest(int[] array, int length) {
        Sort.bubbleSort2(array, length);
        int i;
        for (i=0; i<length-1; i++) {
            if (array[i]+1 < array[i+1]) { break; }
        } 
        return array[i] + 1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Finding smallest integer that haven't showed up in array.");
        System.out.println("Input integer n: ");
        int length = input.nextInt();
        System.out.println("Nhap vao " + length + " so nguyen cua day:");
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("So nho nhat chua xuat hien la " +findSmallest(array, length));
        System.out.println("Day so sau khi sap xep lai la");
        for (int i=0; i<length; ++i) {
            System.out.print(array[i] + " ");
        }
        input.close();
    }
}
