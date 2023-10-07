package hw2_22001273_nguyenhoangminh.excercise1;

import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the length of the array: ");
        int length = input.nextInt();

        // Tạo một array ngẫu nhiên có cỡ N, sử dụng phương thức genArray() của class GenerateArray
        int[] unsorted = GenerateArray.genArray(length);
        System.out.println("Unsorted array: ");
        // GenerateArray.printArray(unsorted);

        double start = System.currentTimeMillis();
        Sort.bubbleSort2(unsorted, length);         // các thuật toán được chứa trong class Sort
        double end = System.currentTimeMillis();
        
        // Đo thời gian chạy thuật toán
        double duration = end-start;

        System.out.println("Sorted array:");
        // GenerateArray.printArray(unsorted);
        System.out.println("Duration (miliseconds): " + duration);
        GenerateArray.displayStats();

        input.close();
    }
}
