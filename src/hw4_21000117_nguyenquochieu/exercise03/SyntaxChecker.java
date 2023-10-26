package hw4_21000117_nguyenquochieu.exercise03;

import java.util.Stack;

public class SyntaxChecker {
    /*
    Check whether the syntax of an expression is valid
     */
    private String expression;

    public SyntaxChecker(String expression) {
        this.expression = expression;
    }

    private char getBracket(char bracket) {
        switch (bracket) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return '?';
    }

    public boolean isValid() {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char selectedCharacter = expression.charAt(i);
            if (selectedCharacter == '(') {
                stack.push('(');
                count++;
            } else if (selectedCharacter == '{') {
                stack.push('{');
                count++;
            } else if (selectedCharacter == '[') {
                stack.push('[');
                count++;
            } else if (getBracket(selectedCharacter) != '?' && count > 0) {
                if (!stack.isEmpty()) {
                    char termCharacter = stack.pop();
                    if (termCharacter == getBracket(selectedCharacter)) {
                        count--;
                    } else return false;
                } else return false;
            } else if (getBracket(selectedCharacter) != '?' && count == 0) {
                return false;
            }
        }
        if (count == 0) return true;
        return false;
    }
}
//g.addEdge(0, 3, 1);
//        g.addEdge(0, 4, 2);
//        g.addEdge(1, 0, 2);
//        g.addEdge(4, 6, 4);
//        g.addEdge(6, 4, 3);
//        g.addEdge(1, 6, 2);
//        g.addEdge(3, 1, 3);
//        g.addEdge(3, 7, 4);
//        g.addEdge(7, 5, 3);
//        g.addEdge(5,7, 1);
//        g.addEdge(5, 6, 5);
//        g.addEdge(2, 5, 4);
//        g.addEdge(6, 2, 5);
//        g.addEdge(2, 6, 1);