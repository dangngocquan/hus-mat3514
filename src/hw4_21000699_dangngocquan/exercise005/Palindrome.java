package hw4_21000699_dangngocquan.exercise005;

import hw4_21000699_dangngocquan.base.queue.LinkedListQueue;
import hw4_21000699_dangngocquan.base.queue.QueueInterface;
import hw4_21000699_dangngocquan.base.stack.LinkedListStack;
import hw4_21000699_dangngocquan.base.stack.StackInterface;

public class Palindrome {
    public static boolean isPalindrome(String document) {
        String s = document.toLowerCase();
        QueueInterface<Character> queue = new LinkedListQueue<>();
        StackInterface<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        int count = s.length() / 2;
        while (count-- > 0) {
            if (stack.pop() != queue.dequeue()) return false;
        }

        return true;
    }
}
