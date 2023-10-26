package hw4_22001273_nguyenhoangminh.excercise5;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;
import hw4_22001273_nguyenhoangminh.excercise4.ArrayQueue;

public class CheckPalindrome {
    public static boolean isPalindrome(String inStr) {
        LinkedListStack<Character> reverse = new LinkedListStack<>();
        ArrayQueue<Character> forward = new ArrayQueue<>();
        inStr = inStr.toUpperCase();

        // Filling stack and queue
        for (int i = 0; i < inStr.length(); ++i) {
            if (inStr.charAt(i) >= 'A' && inStr.charAt(i) <= 'Z') {
                reverse.push(inStr.charAt(i));
                forward.enqueue(inStr.charAt(i));
            }
        }

        // Check if forward.enqueue() is equal to reverse.push()
        for (int i = 0; i < inStr.length(); ++i) {
            if (!reverse.pop().equals(forward.dequeue())) { return false; }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("radar"));
    }
}
