package hw4_21000117_nguyenquochieu.exercise03;

import java.util.Stack;

public class ExpressionCalculator {
    /*
    Calculate the value of expression
     */
    private String expression;

    public ExpressionCalculator(String expression) {
        this.expression = expression;
        check();
    }

    private void check() {
        SyntaxChecker checker = new SyntaxChecker(expression);
        if (!checker.isValid()) {
            System.out.println("SYNTAX ERROR!");
            System.exit(1);
        } else System.out.println("VALID SYNTAX: Value of the expression will be calculated");
    }

    public int calculate() {

        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    buffer.append(tokens[i++]);
                values.push(Integer.parseInt(buffer.
                        toString()));
                i--;
            } else if (tokens[i] == '(')
                operators.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    values.push(calculate(operators.pop(),
                            values.pop(),
                            values.pop()));
                operators.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                while (!operators.empty() &&
                        hasPrecedence(tokens[i],
                                operators.peek()))
                    values.push(calculate(operators.pop(),
                            values.pop(),
                            values.pop()));
                operators.push(tokens[i]);
            }
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // operators to remaining values
        while (!operators.empty())
            values.push(calculate(operators.pop(),
                    values.pop(),
                    values.pop()));

        // Top of 'values' contains
        // result, return it
        return values.pop();
    }

    private boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private int calculate(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}

