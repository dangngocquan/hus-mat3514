package hw4_21000676_damhaidang.ex5;

import java.util.Scanner;

public class PalindromeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chuỗi cần kiểm tra: ");
        String input = sc.nextLine();
        System.out.println("Chuỗi là Palindrome? " + (isPalindrome(input) ? "Đúng" : "Sai"));
    }

    public static boolean isPalindrome(String str) {
        QueueInterface<Character> queue = new LinkedListQueue<>();
        StackInterface<Character> stack = new LinkedListStack<>();
        str = str.toLowerCase().replaceAll("[\\W+]", "");
        
        for (Character c : str.toCharArray()) {
            queue.enqueue(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (queue.dequeue() != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
