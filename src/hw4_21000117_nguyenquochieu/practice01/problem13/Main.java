package hw4_21000117_nguyenquochieu.practice01.problem13;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String stack(String s) {
        Stack<Character> data = new Stack<>();
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) data.push(letters[i]);
        StringBuilder builder = new StringBuilder();
        while (!data.isEmpty()) {
            char letter = data.pop();
            builder.append(letter);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(stack(s));
    }
}
