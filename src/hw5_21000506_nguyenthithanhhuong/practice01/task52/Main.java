package hw5_21000506_nguyenthithanhhuong.practice01.task52;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        sc.close();

        System.out.printf("Output: %d", recursion(n));
    }

    // calculate n!
    public static long recursion(int n) {
        if (n == 0) {
            return 1;
        }
        return n*recursion(n - 1);
    }
}

//    Example run test:
//
//    Example 01:
//    Enter the number: 3
//    Output: 6
//
//    Example 02:
//    Enter the number: 5
//    Output: 120
//
//    Example 03:
//    Enter the number: 8
//    Output: 40320
