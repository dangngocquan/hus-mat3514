package hw4_22001273_nguyenhoangminh.excercise3;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;

public class MatchingParenthesis {
    public static boolean isMatch(String expression) {
        final String OPENINGS = "([{";
        final String CLOSINGS = ")]}";
        
        LinkedListStack<Character> buffer = new LinkedListStack<>();

        for (char c : expression.toCharArray()) {
            if (OPENINGS.indexOf(c) != -1) {
                buffer.push(c);
            } else if (CLOSINGS.indexOf(c) != -1) {
                if (buffer.isEmpty()) return false;
                if (CLOSINGS.indexOf(c) != OPENINGS.indexOf(buffer.pop())) return false;
            }
        }

        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "{}{}{}{}{}[][][][][]()()()";
        String test2 = "{[()]}";
        System.out.println(isMatch(test1));
        System.out.println(isMatch(test2));
    }
}
