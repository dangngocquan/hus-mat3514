package hw4_21000689_nguyenxuanloi.exercises.ex3;

import hw4_21000689_nguyenxuanloi.exercises.ex2.LinkedListStack;
import hw4_21000689_nguyenxuanloi.exercises.ex2.StackInterface;

import java.util.Scanner;

public class ValidBracketsTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer expression that satisfies numbers and operators separated by spaces:\n");
        String integerExpression = sc.nextLine();
        System.out.println(testValidBrackets(integerExpression) ? "String is a valid expression."
                : "String is an invalid expression.");
        if (testValidBrackets(integerExpression)) {
            System.out.println("Result = " + Calculator.evaluateIntegerExpression(integerExpression));
        }

        System.out.print("Enter an expression that satisfies numbers and operators separated by spaces:\n");
        String expression = sc.nextLine();
        sc.close();
        System.out.println(expression + " = " + Calculator.evaluateGeneralExpression(expression));
    }

    static boolean testValidBrackets(String expression) {
        StackInterface<Character> openBrackets = new LinkedListStack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '('
            || expression.charAt(i) == '{'
            || expression.charAt(i) == '[') {
                openBrackets.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')'
                    || expression.charAt(i) == '}'
                    || expression.charAt(i) == ']') {
                if (!openBrackets.isEmpty()) {
                    Character open = openBrackets.pop();
                    if (expression.charAt(i) - open != 1 && expression.charAt(i) - open != 2) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return openBrackets.isEmpty();
    }
}