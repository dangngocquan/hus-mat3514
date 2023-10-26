package hw4_21000689_nguyenxuanloi.exercises.ex3;

import hw4_21000689_nguyenxuanloi.exercises.ex2.LinkedListStack;
import hw4_21000689_nguyenxuanloi.exercises.ex2.StackInterface;

public class Calculator {
    static Character[] operatorsChar = {'+', '-', '*', '/', '^'};
    static Character[] openBracketsChar = {'(', '{', '['};
    static Character[] closeBracketsChar = {')', '}', ']'};

    static int evaluateIntegerExpression(String expression) throws Exception {
        if (!ValidBracketsTest.testValidBrackets(expression)) {
            System.out.println("Cannot evaluate.");
            return 0;
        } else {
            StackInterface<Integer> numbers = new LinkedListStack<>();
            StackInterface<Character> operators = new LinkedListStack<>();
            for (int i = 0; i < expression.length(); i++) {
                if (isOpenBracketChar(expression.charAt(i))) { // If it is an open bracket character, push into stack "operators"
                    operators.push(expression.charAt(i));
                    if (expression.charAt(i + 1) == '-') { // catch the negative number
                        numbers.push(0);
                    }
                }
                if (isDigitChar(expression.charAt(i))) {
                    // Read the number and push it into stack "numbers"
                    StringBuilder number = new StringBuilder();
                    while (i < expression.length() && isDigitChar(expression.charAt(i))) {
                        number.append(expression.charAt(i));
                        i++;
                    }
                    numbers.push(Integer.parseInt(number.toString()));
                    i--;
                }
                if (isOperatorChar(expression.charAt(i))) { // Perform higher order operators first,
                    // then push the new operator into stack "operators"
                    while (!operators.isEmpty() && order(expression.charAt(i)) <= order(operators.top())) {
                        Integer after = numbers.pop();
                        Integer before = numbers.pop();
                        numbers.push(calculate(before, after, operators.pop()));
                    }
                    operators.push(expression.charAt(i));
                }
                if (isCloseBracketChar(expression.charAt(i))) { // Calculate until meet the open bracket
                    char temp = operators.pop();
                    while (!operators.isEmpty() && (expression.charAt(i) - temp != 1
                            && expression.charAt(i) - temp != 2)) {
                        Integer after = numbers.pop();
                        Integer before = numbers.pop();
                        numbers.push(calculate(before, after, temp));
                        temp = operators.pop();
                    }
                }
            }

            while (!operators.isEmpty()) { // Handle the rest operators with sorted order
                int after = numbers.pop();
                int before = numbers.isEmpty() ? 0 : numbers.pop();
                numbers.push(calculate(before, after, operators.pop()));
            }
            return numbers.pop();
        }
    }
    static double evaluateGeneralExpression(String expression) throws Exception {
        if (!ValidBracketsTest.testValidBrackets(expression)) {
            System.out.println("Cannot evaluate.");
            return 0;
        } else {
            StackInterface<Double> numbers = new LinkedListStack<>();
            StackInterface<Character> operators = new LinkedListStack<>();
            for (int i = 0; i < expression.length(); i++) {
                if (isOpenBracketChar(expression.charAt(i))) { // If it is an open bracket character, push into stack "operators"
                    operators.push(expression.charAt(i));
                    if (expression.charAt(i + 1) == '-') { // catch the negative number
                        numbers.push(0.0);
                    }
                }
                if (isDigitChar(expression.charAt(i))) {
                    // Read the number and push it into stack "numbers"
                    StringBuilder number = new StringBuilder();
                    while (i < expression.length() && (isDigitChar(expression.charAt(i))
                            || expression.charAt(i) == '.')) {
                        number.append(expression.charAt(i));
                        i++;
                    }
                    numbers.push(Double.parseDouble(number.toString()));
                    i--;
                }
                if (isOperatorChar(expression.charAt(i))) { // Perform higher order operators first,
                    // then push the new operator into stack "operators"
                    while (!operators.isEmpty() && order(expression.charAt(i)) <= order(operators.top())) {
                        Double after = numbers.pop();
                        Double before = numbers.pop();
                        numbers.push(calculate(before, after, operators.pop()));
                    }
                    operators.push(expression.charAt(i));
                }
                if (isCloseBracketChar(expression.charAt(i))) { // Calculate until meet the open bracket
                    char temp = operators.pop();
                    while (!operators.isEmpty() && (expression.charAt(i) - temp != 1
                            && expression.charAt(i) - temp != 2)) {
                        Double after = numbers.pop();
                        Double before = numbers.pop();
                        numbers.push(calculate(before, after, temp));
                        temp = operators.pop();
                    }
                }
            }

            while (!operators.isEmpty()) { // Handle the rest operators with sorted order
                double after = numbers.pop();
                double before = numbers.isEmpty() ? 0 : numbers.pop();
                numbers.push(calculate(before, after, operators.pop()));
            }
            return numbers.pop();
        }
    }

    static boolean isOperatorChar(Character c) {
        for (Character operator: operatorsChar) {
            if (c == operator) {
                return true;
            }
        }
        return false;
    }

    static boolean isDigitChar(Character c) {
        return '0' <= c && c <= '9';
    }

    static boolean isCloseBracketChar(Character c) {
        for (Character bracket: closeBracketsChar) {
            if (c == bracket) {
                return true;
            }
        }
        return false;
    }
    static boolean isOpenBracketChar(Character c) {
        for (Character bracket: openBracketsChar) {
            if (c == bracket) {
                return true;
            }
        }
        return false;
    }

    static int order(char operator) {
        switch (operator) {
            case '(', '[', '{' -> {
                return 0;
            }
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return -1;
    }

    static int calculate(int number1, int number2, char operator) throws Exception {
        switch (operator) {
            case '+' -> {
                return number1 + number2;
            }
            case '-' -> {
                return number1 - number2;
            }
            case '*' -> {
                return number1 * number2;
            }
            case '/' -> {
                if (number2 == 0) {
                    throw new Exception("Invalid divisor.");
                } else {
                    return number1 / number2;
                }
            }
            case '^' -> {
                if (number1 * number1 <= 1) {
                    return (int) Math.pow(number1, number2);
                } else {
                    if (number2 < 0) {
                        throw new Exception("Invalid exponential.");
                    } else {
                        return (int) Math.pow(number1, number2);
                    }
                }
            }
        }
        return -1;
    }
    static double calculate(double number1, double number2, char operator) throws Exception {
        switch (operator) {
            case '+' -> {
                return number1 + number2;
            }
            case '-' -> {
                return number1 - number2;
            }
            case '*' -> {
                return number1 * number2;
            }
            case '/' -> {
                if (number2 == 0) {
                    throw new Exception("Invalid divisor.");
                } else {
                    return number1 / number2;
                }
            }
            case '^' -> {
                if (number2 == (int) number2) {
                    return (number2 < 0) ? 1 / exponential(number1, (int) Math.abs(number2))
                            : exponential(number1, (int) number2);
                } else {
                    return Math.pow(number1, number2);
                }
            }
        }
        return -1;
    }

    static double exponential(double base, int exponential) {
        double result = 1;
        while (exponential > 0) {
            result *= base;
            exponential--;
        }
        return result;
    }
}
