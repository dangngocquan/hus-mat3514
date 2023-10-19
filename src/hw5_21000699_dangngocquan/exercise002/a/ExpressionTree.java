package hw5_21000699_dangngocquan.exercise002.a;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;
import hw5_21000699_dangngocquan.exercise003.ExpressionTreeBuilder;
import hw5_21000699_dangngocquan.exercise003.ExpressionTreeBuilder2;

import java.util.LinkedList;
import java.util.List;

public class ExpressionTree extends LinkedBinaryTree<String> {
    // PRINT
    public void preorderPrint(Node<String> p) {
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
        if (elementOfNode(left(p)) != null) preorderPrint(left(p));
        if (elementOfNode(right(p)) != null) preorderPrint(right(p));
    }

    public void postorderPrint(Node<String> p) {
        if (elementOfNode(left(p)) != null) postorderPrint(left(p));
        if (elementOfNode(right(p)) != null) postorderPrint(right(p));
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
    }

    public void inorderPrint(Node<String> p) {
        if (numberChildren(p) == 2) System.out.print("(");
        if (elementOfNode(left(p)) != null) inorderPrint(left(p));
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
        if (elementOfNode(right(p)) != null) inorderPrint(right(p));
        if (numberChildren(p) == 2) System.out.print(")");
    }

    // EVALUATE EXPRESSION WITH INPUT IS ROOT NODE OF TREE
    public String evaluateToString() {
        return evaluateToString(root());
    }

    public String evaluateToString(Node<String> p) {
        if (isOperation(elementOfNode(p))) {
            String leftEvaluation = evaluateToString(left(p));
            String rightEvaluation = evaluateToString(right(p));
            if (!isNumber(leftEvaluation)) return leftEvaluation;
            if (!isNumber(rightEvaluation)) return rightEvaluation;
            Double left = Double.parseDouble(leftEvaluation);
            Double right = Double.parseDouble(rightEvaluation);
            switch (elementOfNode(p)) {
                case "+":
                    return (left + right) + "";
                case "-":
                    return left - right + "";
                case "*":
                    return left * right + "";
                case "/":
                    if (Double.compare(right, 0) == 0) return "Divide by zero.";
                    return left / right + "";
                default:
                    return "Invalid expression tree.";
            }
        } else if (isNumber(elementOfNode(p))) {
            return elementOfNode(p);
        } else {
            return "Invalid expression tree.";
        }
    }

    private boolean isNumber(String token) {
        if (token == null) return false;
        return token.matches("([+-])?[0-9]{1,13}(\\.[0-9]*)?(E-[0-9]+)?");
    }

    private boolean isOperation(String token) {
        if (token == null) return false;
        return token.matches("[+\\-*/]");
    }

    // Extend feature (not requirement in this problem, but will useful and easier to test input for user)
    // EVALUATE EXPRESSION WITH INPUT IS AN EXPRESSION STRING
    public static Object createExpressionTree(String expression) {
        String[] tokens = getTokensFromExpressionString(expression);
        // Use a solution from exercise003
        ExpressionTreeBuilder expressionTreeBuilder = new ExpressionTreeBuilder2();
        return expressionTreeBuilder.buildExpressionTree(tokens);
    }

    // Get array tokens from an expression string
    public static String[] getTokensFromExpressionString(String expression) {
        List<String> l = new LinkedList<>();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if ((c <= '9' && c >= '0') || c == '.') {
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
        return l.toArray(new String[0]);
    }

}
