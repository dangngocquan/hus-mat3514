package hw3_22001273_nguyenhoangminh.excercise1;

import java.util.Arrays;
import java.util.Scanner;

public class TestFraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int length = in.nextInt();

        FractionArray fractionArray = new FractionArray(length);

        System.out.println(fractionArray.toString());

        System.out.println("Sum of array: " + fractionArray.sumArray().toString());
        System.out.println("Minus of array: " + fractionArray.minusArray().toString());
        System.out.println("Multiply of array: " + fractionArray.multiArray().toString());
        System.out.println("Division of array: " + fractionArray.divideArray().toString());
        System.out.println("Power 2 of array: " + Arrays.toString(fractionArray.powerArray(2)));
    }
}
