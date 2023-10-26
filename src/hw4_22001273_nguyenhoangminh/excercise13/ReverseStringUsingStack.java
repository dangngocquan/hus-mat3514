package hw4_22001273_nguyenhoangminh.excercise13;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;

public class ReverseStringUsingStack {
    public static String reverse(String inStr) {
        StringBuilder outStr = new StringBuilder();
        LinkedListStack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < inStr.length(); i++) {
            stack.push(inStr.charAt(i));
        }

        int size = stack.size();

        for (int i = 0; i < size; i++) {
            outStr.append(stack.pop());
        }

        return outStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
