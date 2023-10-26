package hw4_22001273_nguyenhoangminh.excercise3;

import hw4_22001273_nguyenhoangminh.excercise2.ArrayStack;

public class Calculate {
    static final String OPENING = "{[(";
    static final String CLOSING = ")]}";
    static final String OPERATORS = "+-*/";

    public static String calculate(String expression) {
        String[] operators =expression.split("[0-9]+");
        String[] operands =expression.split("[-+*/]");

        int result = Integer.parseInt(operands[0]);

        // Treat first operator specially
        if (operators[0].equals("-")) {
            result = - result;
        }

        for (int i = 1; i < operands.length; ++i) {
            switch (operators[i]) {
                case "+" :
                    result += Integer.parseInt(operands[i]);
                    break;
                case "-" :
                    result -= Integer.parseInt(operands[i]);
                    break;
                case "*" :
                    result *= Integer.parseInt(operands[i]);
                    break;
                case "/" :
                    result /= Integer.parseInt(operands[i]);
                    break;
            }
        }

        return Integer.toString(result);
    }


    /* Using Stack buffer to store the expression
    Push characters into buffer and then when c == ')', pop back out and calculate the mini expression inside brackets.
    After calculation, pop the brackets and push the results back.
    Continue doing this until the end of the String expression.
     */
    public static String getResult(String expression) throws IllegalArgumentException {
        if (!MatchingParenthesis.isMatch(expression)) throw new IllegalArgumentException("Invalid expression");
        ArrayStack<Character> buffer = new ArrayStack<>();
        String bracket = "";

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c != ')') {
                buffer.push(c);

            } else {
                String inBrackets = "";
                while (buffer.top() != '(') {
                    inBrackets = buffer.pop() + inBrackets;
                }
                bracket = calculate(inBrackets);
                buffer.pop();
                for (int j = 0; j < bracket.length(); ++j) {
                    buffer.push(bracket.charAt(j));
                }
            }
        }

        return bracket;
    }


    public static void main(String[] args) {
        // Thay bieu thuc vao a de tinh bieu thuc
        String a = "(1-2)*(3-4)";

        System.out.println(getResult(a));
    }
}
