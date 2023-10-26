package hw4_21000689_nguyenxuanloi.practice.ex5;

import hw4_21000689_nguyenxuanloi.practice.ex1.LinkedListStack;
import hw4_21000689_nguyenxuanloi.practice.ex1.StackInterface;

public class EvaluateExpression {
    public static void main(String[] args) throws Exception {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Result = " + evalRPN(tokens));
    }

    static int evalRPN(String[] tokens) throws Exception {
        StackInterface<Integer> integers = new LinkedListStack<>();
        for (String token: tokens) {
            if (!isOperator(token)) {
                integers.push(Integer.parseInt(token));
            } else {
                integers.push(calculate(token, integers.pop(), integers.pop()));
            }
        }
        return integers.pop();
    }

    static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    static int calculate(String operator, int after, int before) throws Exception {
        switch (operator) {
            case "+" -> {
                return before + after;
            }
            case "-" -> {
                return before - after;
            }
            case "*" -> {
                return before * after;
            }
            case "/" -> {
                if (after == 0) {
                    throw new Exception("Cannot divide to zero.");
                }
                return (int) Math.round(before * 1.0 / after);
            }
        }
        return 0;
    }
}
