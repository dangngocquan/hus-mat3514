package hw5_21000506_nguyenthithanhhuong.practice01.task53;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        sc.close();

        System.out.printf("Output: %d", pow(a, b));
    }

    // calculate a^b
    public static int pow(int a, int b) {
        if (b == 0) return 1;
        return a*pow(a, b - 1);
    }
}

//    Example run test:
//
//    Example 01:
//    Enter a: 2
//    Enter b: 5
//    Output: 32
//
//    Example 02:
//    Enter a: 12
//    Enter b: 2
//    Output: 144