package hw4_21000117_nguyenquochieu.practice04;

import java.util.Stack;

public class Solution {

    public Solution() {
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

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char selectedCharacter = s.charAt(i);
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
