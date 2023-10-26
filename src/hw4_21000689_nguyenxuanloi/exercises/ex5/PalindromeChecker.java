package hw4_21000689_nguyenxuanloi.exercises.ex5;

import hw4_21000689_nguyenxuanloi.exercises.ex2.LinkedListStack;
import hw4_21000689_nguyenxuanloi.exercises.ex2.StackInterface;
import hw4_21000689_nguyenxuanloi.exercises.ex4.LinkedListQueue;
import hw4_21000689_nguyenxuanloi.exercises.ex4.QueueInterface;

public class PalindromeChecker {
    static boolean checkPalindromeString(String s) {
        s = s.toLowerCase().replaceAll("\\W+", "");

        StackInterface<Character> firstHalf = new LinkedListStack<>();
        QueueInterface<Character> secondHalf = new LinkedListQueue<>();
        for (int i = 0; i < s.length() / 2; i++) {
            firstHalf.push(s.charAt(i));
            secondHalf.enqueue(s.charAt(s.length() / 2 + i));
        }
        if ((s.length() & 1) == 1) {
            firstHalf.push(s.charAt(s.length() / 2));
            secondHalf.enqueue(s.charAt(s.length() - 1));
        }

        while (!firstHalf.isEmpty()) {
            if (firstHalf.pop() != secondHalf.dequeue()) {
                return false;
            }
        }
        return true;
    }
}
