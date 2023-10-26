package hw4_21000506_nguyenthithanhhuong.ex05;

import hw4_21000506_nguyenthithanhhuong.ex02.LinkedListStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;
import hw4_21000506_nguyenthithanhhuong.ex04.LinkedListQueue;
import hw4_21000506_nguyenthithanhhuong.ex04.QueueInterface;

import java.util.Scanner;

public class Palindrome {
    public Palindrome() {
        String input = input();
        System.out.println("Result: " + isPalindrome(input));
    }

    // Read input string by keyboard
    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String inputStr = sc.nextLine();
        sc.close();
        return inputStr;
    }

    // Solve
    // Check a string is a palindrome or not
    public static boolean isPalindrome(String inputStr) {
        inputStr = inputStr.toLowerCase();
        StackInterface<Character> stack = new LinkedListStack<>();
        QueueInterface<Character> queue = new LinkedListQueue<>();

        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            stack.push(ch);
            queue.enqueue(ch);
        }

        for (int j = 0; j < inputStr.length()/2; j++) {
            if (stack.pop().compareTo(queue.dequeue()) != 0) return false;
        }

        return true;
    }
}
