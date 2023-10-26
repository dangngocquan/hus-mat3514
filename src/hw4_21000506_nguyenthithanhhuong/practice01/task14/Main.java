package hw4_21000506_nguyenthithanhhuong.practice01.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        sc.close();

        System.out.println("Output: ");
        System.out.println(StackBinary.stackBinary(num));
    }

    //    Example
    //    Enter the number:
    //    104
    //    Output:
    //    1101000
}
