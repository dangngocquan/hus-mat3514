package hw4_21000117_nguyenquochieu.exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string to check: ");
        String input = scanner.nextLine();
        PalindromeChecker checker = new PalindromeChecker(input);
        System.out.println(checker.isPalindrome());
    }
}
