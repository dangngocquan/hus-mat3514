package hw5_21000699_dangngocquan.exercise002.c;

import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

public class Test {
    public void run() {
        // Set your input test here
        testEvaluateExpression("(6/3+2)*(7-4)");
        testEvaluateExpression("1+2*3-1/2*2");
        testEvaluateExpression("(1/2)+0.3");
        testEvaluateExpression("(1/2+0.5+3.2)/2/3");
        testEvaluateExpression("3/0+2");
        testEvaluateExpression("-1.2+0.3*2");
        testEvaluateExpression("-1.2/3");
        testEvaluateExpression("-1.2/3+0.4");
        testEvaluateExpression("1.5*3");
        testEvaluateExpression("-1.2/3+0.4+1.5*3");

    }

    public void testEvaluateExpression(String expression) {
        System.out.println("INPUT");
        System.out.println("Expression string: " + expression);
        Object expressionTree = ExpressionTree.createExpressionTree(expression);
        if (expressionTree instanceof ExpressionTree tree) {
            System.out.println("Expression tree: ");
            System.out.println(expressionTree);
            System.out.println("\nOUTPUT:");
            System.out.println(tree.evaluateToString());
        } else {
            System.out.println(expressionTree);
        }
        System.out.println("-".repeat(80));
    }
}
