package hw4_21000506_nguyenthithanhhuong.ex03;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    // Exercise 3.a
    // Check balanced bracket of expression
    public static boolean isBalancedBracket(String expression) {
        StackInterface stack = new ArrayStack();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char check = (char) stack.pop();
                    switch (ch) {
                        case ')':
                            if (check == '[' || check == '{') {
                                return false;
                            }
                            break;
                        case ']':
                            if (check == '(' || check == '{') {
                                return false;
                            }
                            break;
                        case '}':
                            if (check == '(' || check == '[') {
                                return false;
                            }
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    // Exercise 3.b
    // Convert expression to infix list<String>
    public static List<String> expressionToInfix(String expression) {
        List<String> result = new ArrayList<>();
        String token = "";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                token += ch;
            } else {
                if (token != "") {
                    result.add(token);
                }
                token = "";
                result.add(ch + "");
            }
        }
        if (token != "") {
            result.add(token);
        }
        return result;
    }

    // Infix to Postfix Conversion
    public static List<String> infixToPostfix(String expression) {
        List<String> infix = expressionToInfix(expression);

        StackInterface<String> stack = new ArrayStack<>();
        List<String> postfix = new ArrayList<>();

        for (String str : infix) {
            if (isNumber(str)) {
                postfix.add(str);
            } else if (str.equals("(")) {
                stack.push(str);
            } else if (str.equals(")")) {
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && precedence(str) <= precedence(stack.top())) {
                    postfix.add(stack.pop());
                }
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.top().equals("("))
                System.out.println("Invalid Expression");
            postfix.add(stack.top());
            stack.pop();
        }
        return postfix;
    }

    // Check a String is a number or not
    public static boolean isNumber(String str) {
        Integer num = null;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {

        }
        if (num == null) return false;
        return true;
    }

    // Precedence of operation
    // higher value ~ higher precedence
    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    // Calculate postfix expression value
    public static int calculatePostfixExpression(String expression) {
        List<String> postfix = infixToPostfix(expression);

        StackInterface<Integer> stack = new ArrayStack<>();

        for (String str : postfix) {
            if (isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int value1 = stack.pop();
                int value2 = stack.pop();

                switch (str) {
                    case "+":
                        stack.push(value2 + value1);
                        break;
                    case "-":
                        stack.push(value2 - value1);
                        break;
                    case "/":
                        stack.push(value2 / value1);
                        break;
                    case "*":
                        stack.push(value2 * value1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Calculate expression value
    public static int calculateExpression(String expression) {
        if (!isBalancedBracket(expression)) {
            System.out.println("Invalid expression...");
        }
        int result = calculatePostfixExpression(expression);
        return result;
    }
}
