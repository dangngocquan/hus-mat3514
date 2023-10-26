package hw4_21000676_damhaidang.ex3;

import java.util.Scanner;
import java.util.Stack;


public class CheckBalancedBrackets {
    private static final String OPERATORS = "+-*/";
    private static final int[] PRECEDENCE = {1, 1, 2, 2};

    private static int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    private static boolean isOperator(char c) {
        return OPERATORS.indexOf(c) != -1;
    }


    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean lastDigit = false;

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                if (lastDigit) {
                    postfix.append(c);
                } else {
                    postfix.append(' ').append(c);
                    lastDigit = true;
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(' ').append(stack.pop());
                }
                stack.push(c);
                lastDigit = false;
            } else if (c == '(') {
                stack.push(c);
                lastDigit = false;
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(' ').append(stack.pop());
                }
                stack.pop();
                lastDigit = false;
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(' ').append(stack.pop());
        }

        return postfix.toString();
    }

    // Tính toán kết quả của biểu thức nhập vào
    private static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix.trim().split("\\s+")) {
            if (isOperator(token.charAt(0))) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // Lấy biểu thức số học để xử lý
    public static String importArithmeticExpression(Scanner sc) {
        String input = sc.nextLine();
        return input;
    }

    // Trả về chuỗi chứa toàn bộ các dấu ngoặc của biểu thức
    public static String getAllBrackets(String expression) {
        StringBuilder brackets = new StringBuilder();
        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(':
                case ')':
                case '[':
                case ']':
                case '{':
                case '}':
                    brackets.append(c);
            }
        }
        return brackets.toString();
    }

    // Kiểm tra biểu thức có hợp lệ về thứ tự dấu ngoặc không
    public static boolean isValid(String expression) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập biểu thức số học: ");
        String expression = importArithmeticExpression(sc);
        String brackets = getAllBrackets(expression);

        if (isValid(brackets)) {
            String postFix = infixToPostfix(expression);
            int result = evaluatePostfix(postFix);
            System.out.println("Hợp lệ");
            System.out.println("Giá trị của biểu thức là: " + result);
        } else {
            System.out.println("Không hợp lệ");
        }

    }
}
