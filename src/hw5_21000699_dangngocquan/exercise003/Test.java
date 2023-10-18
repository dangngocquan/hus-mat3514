package hw5_21000699_dangngocquan.exercise003;

import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

import java.util.Arrays;

public class Test {
    public void run() {
        header();
        testSolution1(new String[] {
                "(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4"
        });
        testSolution2(new String[] {
                "(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4"
        });
        testSolution1(new String[] {
                "(", "5", "+", "3", ")", "*", "2"
        });
        testSolution2(new String[] {
                "(", "5", "+", "3", ")", "*", "2"
        });
        testSolution1(new String[] {
                "(", "(", "5", "+", "3", ")", "*", "2", ")", "/", "(", "1", "+", "3", ")"
        });
        testSolution2(new String[] {
                "(", "(", "5", "+", "3", ")", "*", "2", ")", "/", "(", "1", "+", "3", ")"
        });
        testSolution1(new String[] {
                "(", "(", "(", "2", "*", "3", ")", "+", "4", ")", "*", "(", "3", "-", "(", "1", "+", "2", ")", ")", ")"
        });
        testSolution2(new String[] {
                "(", "(", "(", "2", "*", "3", ")", "+", "4", ")", "*", "(", "3", "-", "(", "1", "+", "2", ")", ")", ")"
        });
        testSolution1(new String[] {
                "(", ")"
        });
        testSolution2(new String[] {
                "(", ")"
        });
        testSolution1(new String[] {
                "10", "4"
        });
        testSolution2(new String[] {
                "10", "4"
        });
        testSolution1(new String[] {
                "10", "+", "4", "18"
        });
        testSolution2(new String[] {
                "10", "+", "4", "18"
        });
        testSolution1(new String[] {
                "*", "4"
        });
        testSolution2(new String[] {
                "*", "4"
        });
        testSolution1(new String[] {
                "10", "*", "-"
        });
        testSolution2(new String[] {
                "10", "*", "-"
        });
        testSolution1(new String[] {
                "10", "+", "4", ")"
        });
        testSolution2(new String[] {
                "10", "+", "4", ")"
        });
        testSolution1(new String[] {
                "(", "104", ")"
        });
        testSolution2(new String[] {
                "(", "104", ")"
        });
        testSolution1(new String[] {
                "(", "-", "104", ")"
        });
        testSolution2(new String[] {
                "(", "-", "104", ")"
        });
        testSolution1(new String[] {
                "-", "104"
        });
        testSolution2(new String[] {
                "-", "104"
        });
        testSolution1(new String[] {
                "(", "-", "104", ")", "(", "1812", "+", "12", "(", "18",")"
        });
        testSolution2(new String[] {
                "(", "-", "104", ")", "(", "1812", "+", "12", "(", "18",")"
        });
    }

    private void header() {
        System.out.printf(
                "%-20s  %-80s  %s\n",
                "Solution using",
                "Input (Array tokens)",
                "Output (Expression tree)"
        );
        System.out.println("-".repeat(180));
    }

    public void testSolution1(String[] tokens) {
        Object result = new Solution1().buildExpressionTree(tokens);
        String output = result.toString();
        if (result instanceof ExpressionTree)
            output = output.replace("\n", "\n" + " ".repeat(104));
        System.out.printf(
                "%-20s  %-80s  %s\n",
                "Solution 1",
                Arrays.toString(tokens),
                output
        );
        System.out.println("-".repeat(180));
    }

    public void testSolution2(String[] tokens) {
        Object result = new Solution2().buildExpressionTree(tokens);
        String output = result.toString();
        if (result instanceof ExpressionTree)
            output = output.replace("\n", "\n" + " ".repeat(104));
        System.out.printf(
                "%-20s  %-80s  %s\n",
                "Solution 2",
                Arrays.toString(tokens),
                output
        );
        System.out.println("-".repeat(180));
    }
}
