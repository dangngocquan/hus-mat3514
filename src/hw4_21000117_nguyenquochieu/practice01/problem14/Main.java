package hw4_21000117_nguyenquochieu.practice01.problem14;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String stack(int n) {
        Stack<Integer> data = new Stack<>();
        while (n > 0) {
            data.push(n % 2);
            n = n / 2;
        }
        StringBuilder builder = new StringBuilder();
        while (!data.isEmpty()) {
            int digit = data.pop();
            builder.append(digit);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String binaryString = stack(n);
        System.out.println(binaryString);
    }
}
