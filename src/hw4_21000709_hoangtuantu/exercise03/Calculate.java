package hw4_21000709_hoangtuantu.exercise03;

import hw4_21000709_hoangtuantu.exercise02.ArrayStack;
import hw4_21000709_hoangtuantu.exercise02.Stack;

public class Calculate {
    public static double calculate(String expression) throws Exception {
        if (!ValidParentheses.valid(expression)) {
            throw new ArithmeticException("In-valid expression!");
        }
        double           result    = 0;
        Stack<Double>    numbers   = new ArrayStack<>();
        Stack<Character> operators = new ArrayStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                double num = Double.parseDouble(numStr.toString());
                numbers.push(num);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.top() != '(') {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operator = operators.pop();
                    double resultInParentheses = performOperation(a, b, operator);
                    numbers.push(resultInParentheses);
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.top()) >= precedence(c)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operator = operators.pop();
                    double resultOperator = performOperation(a, b, operator);
                    numbers.push(resultOperator);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char operator = operators.pop();
            double resultOperator = performOperation(a, b, operator);
            numbers.push(resultOperator);
        }

        if (!numbers.isEmpty()) {
            result = numbers.pop();
        }

        return result;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private static double performOperation(double a, double b, char operator) {
        switch (operator) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                if (b == 0){
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            }
            default -> {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String[] expressions = new String[]{"(1 + ((2 + 3) * (8 * 5)))", "(5 − (8 − 4) * (2 + 3)) + (8 / 4)"};
        for (String expression:expressions){
            try{
                System.out.println("Expression " + expression + " have result: " + calculate(expression));
            }catch (Exception e){
                System.out.println(expression + " Is not a valid expression");
            }
        }
    }

}
