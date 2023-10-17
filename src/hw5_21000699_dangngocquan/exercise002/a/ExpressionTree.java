package hw5_21000699_dangngocquan.exercise002.a;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;

public class ExpressionTree extends LinkedBinaryTree<String> {
    // PRINT
    public void preorderPrint(LinkedBinaryTreeNode<String> p) {
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
        if (elementOfNode(left(p)) != null) preorderPrint(left(p));
        if (elementOfNode(right(p)) != null) preorderPrint(right(p));
    }

    public void postorderPrint(LinkedBinaryTreeNode<String> p) {
        if (elementOfNode(left(p)) != null) postorderPrint(left(p));
        if (elementOfNode(right(p)) != null) postorderPrint(right(p));
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
    }

    public void inorderPrint(LinkedBinaryTreeNode<String> p) {
        if (numberChildren(p) == 2) System.out.print("(");
        if (elementOfNode(left(p)) != null) inorderPrint(left(p));
        if (elementOfNode(p) != null) System.out.print(" " + elementOfNode(p) + " ");
        if (elementOfNode(right(p)) != null) inorderPrint(right(p));
        if (numberChildren(p) == 2) System.out.print(")");
    }

    // EVALUATION
    public Double evaluate() {
        String evaluation = evaluateToString();
        if (isNumber(evaluation)) return Double.parseDouble(evaluation);
        return null;
    }

    public String evaluateToString() {
        return evaluateToString(root());
    }

    private String evaluateToString(LinkedBinaryTreeNode<String> p) {
        if (isOperation(elementOfNode(p))) {
            String leftEvaluation = evaluateToString(left(p));
            String rightEvaluation = evaluateToString(right(p));
            if (!isNumber(leftEvaluation)) return leftEvaluation;
            if (!isNumber(rightEvaluation)) return rightEvaluation;
            Double left = Double.parseDouble(leftEvaluation);
            Double right = Double.parseDouble(rightEvaluation);
            switch (elementOfNode(p)) {
                case "+":
                    return left + right + "";
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
        return token.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }

    private boolean isOperation(String token) {
        if (token == null) return false;
        return token.matches("[+\\-*/]");
    }
}
