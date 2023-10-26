package hw4_21000689_nguyenxuanloi.exercises.ex5;

import java.util.Scanner;

public class PalindromeCheckerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        sc.close();

        System.out.println(PalindromeChecker.checkPalindromeString(s) ? "Input string is palindrome."
                                                                    : "Input string is not palindrome.");
    }
}
