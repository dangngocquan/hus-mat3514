package hw4_21000506_nguyenthithanhhuong.practice01.task13;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;

public class ReverseString {
    public static String stack(String str) {
        StringBuilder sb = new StringBuilder();
        StackInterface stack = new ArrayStack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
