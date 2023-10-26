package hw4_21000117_nguyenquochieu.exercise05;

import hw4_21000117_nguyenquochieu.exercise02.LinkedListStack;
import hw4_21000117_nguyenquochieu.exercise04.LinkedListQueue;

public class PalindromeChecker {
    private String input;
    private LinkedListStack<Character> stack = new LinkedListStack<>();
    private LinkedListQueue<Character> queue = new LinkedListQueue<>();
    public PalindromeChecker(String input) {
        this.input = input;
        getData();
    }
    private void getData() {
        for (Character character : input.toCharArray()) {
            stack.push(character);
            queue.enqueue(character);
        }
    }
    public boolean isPalindrome() {
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.dequeue()) return false;
        }
        return true;
    }
}
