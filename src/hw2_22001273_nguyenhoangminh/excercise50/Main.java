package hw2_22001273_nguyenhoangminh.excercise50;

import java.util.Scanner;

import hw2_22001273_nguyenhoangminh.excercise1.Sort;

public class Main {
    // Check so chinh phuong
    public static boolean checkSquare(int n) {
        //calculating the square root of the given number  
        double sqrt=Math.sqrt(n);   
        //finds the floor value of the square root and comparing it with zero  
        return ((sqrt - Math.floor(sqrt)) == 0);   
    }

    public static void main(String[] args) {
        int numOfSquare = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao day so gom n so va in ra cac so chinh phuong theo thu tu tang dan");
        System.out.println("Input integer n: ");
        int length = input.nextInt();
        System.out.println("Nhap vao " + length + " so nguyen cua day:");
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = input.nextInt();
        }
        Sort.bubbleSort2(array, length);
        System.out.println("Cac so chinh phuong la:");
        for (int i=0; i<length; ++i) {
            if(checkSquare(array[i])) {
                System.out.print(array[i] + " ");
                numOfSquare++;
            }
        }
        if (numOfSquare==0) { System.out.println("NULL"); }
        input.close();
    }
}
