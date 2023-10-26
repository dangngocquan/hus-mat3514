package hw4_21000506_nguyenthithanhhuong.practice01.task13;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input string: ");
        String inputString = sc.nextLine();
        sc.close();

        System.out.println("Output String: ");
        System.out.println(ReverseString.stack(inputString));
    }

    //    Example:
    //    Enter input string:
    //    Code learn
    //    Output String:
    //    nrael edoC
}

