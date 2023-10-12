package hw4_21000699_dangngocquan.exercise003;

import hw4_21000699_dangngocquan.base.stack.LinkedListStack;
import hw4_21000699_dangngocquan.base.stack.StackInterface;

import java.util.LinkedList;
import java.util.List;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isValidBrackets() {
        StackInterface<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidExpression() {
        // Checkt valid brackets ( )
        if (!isValidBrackets()) return false;

        // Expression only have character 0 1 2 3 4 5 6 7 8 9 + - * / ( )
        if (!expression.matches("[0-9+\\-*/()]*")) return false;

        char prevChar = expression.charAt(0);
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // Check invalid cases
            if (isDigit(prevChar)) {
                if (isOpenBracket(c)) return false;
                // Example: 2( is invalid
            } else if (isOperation(prevChar)) {
                if (isOperation(c)) return false;
                // Example: +- is invalid
                if (isCloseBracket(c)) return false;
                // Example: +) is invalid
            } else if (isOpenBracket(prevChar)) {
                if (isOperation(c) && c != '-' && c != '+') return false;
                // Example: (* and (/ are invalid
                if (isCloseBracket(c)) return false;
                // Example: () is invalid (don't have any value in those brackets)
            } else if (isCloseBracket(prevChar)) {
                if (isOpenBracket(c)) return false;
                // Example: )( is invalid
                if (isDigit(c)) return false;
                // Example: ")2" is invalid
            }

            // Update prevChar
            prevChar = c;
        }

        // Check last character
        return !isOperation(prevChar);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isOpenBracket(char c) {
        return c == '(';
    }

    private boolean isCloseBracket(char c) {
        return c == ')';
    }

    private int getPriorityOperation(String operation) {
        if (operation == null) return 0;
        if (operation.equals("*") || operation.equals("/")) return 2;
        if (operation.equals("+") || operation.equals("-")) return 1;
        return 0;
    }

    // Example: "-12+3*2" --> "0-12+3*2"
    // Example: "12+(-3+2)*2" --> "12+(0-3+2)*2"
    private String getNormalizeExpression() {
        StringBuilder sb = new StringBuilder();

        char prevChar = '(';
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+') {
                if (isOpenBracket(prevChar)) {
                    sb.append('0');
                }
            }
            sb.append(c);
            prevChar = c;
        }
        return sb.toString();
    }

    public List<String> expressionToInfix() {
        List<String> l = new LinkedList<>();
        if (!isValidExpression()) return l;

        String e = getNormalizeExpression();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < e.length(); i++) {
            char c = e.charAt(i);
            if (isDigit(c)) {
                token.append(c);
            } else {
                if (token.length() > 0) {
                    l.add(token.toString());
                    token = new StringBuilder();
                }
                l.add(c + "");
            }
        }

        if (token.length() > 0) {
            l.add(token.toString());
        }

        return l;
    }

    public List<String> infixToPostfix(List<String> infix) {
        List<String> postfix = new LinkedList<>();
        StackInterface<String> stackOperations = new LinkedListStack<>();

        for (String token : infix) {
            if (token.matches("[0-9]+")) {  // If token is a number
                postfix.add(token);
            } else if (token.equals("(")) {
                stackOperations.push(token);
            } else if (token.equals(")")) {
                while (!stackOperations.top().equals("(")) {
                    postfix.add(stackOperations.pop());
                }
                stackOperations.pop();
            } else { // If token is an operation
                if (stackOperations.size() == 0) {
                    stackOperations.push(token);
                    continue;
                }
                int currentPriority = getPriorityOperation(token);
                int topPriority = getPriorityOperation(stackOperations.top());
                while (currentPriority <= topPriority) {
                    postfix.add(stackOperations.pop());
                    if (stackOperations.isEmpty()) break;
                    topPriority = getPriorityOperation(stackOperations.top());
                }
                stackOperations.push(token);
            }
        }

        while (!stackOperations.isEmpty()) postfix.add(stackOperations.pop());

        return postfix;
    }

    public String evaluate(List<String> postfix) {
        if (postfix.isEmpty()) return "Invalid";

        StackInterface<String> stack = new LinkedListStack<>();
        for (String token : postfix) {
            if (token.matches("[0-9]+")) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (token) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> {
                        if (num2 == 0) return "Divide by zero";
                        result = num1 / num2;
                    }
                    default -> {
                    }
                }
                stack.push(result + "");
            }
        }

        return stack.pop();
    }
}
