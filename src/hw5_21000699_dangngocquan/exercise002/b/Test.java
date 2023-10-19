package hw5_21000699_dangngocquan.exercise002.b;

import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

public class Test {
    public void run() {
        // Set your input test here
        testExpressionString("(6/3+2)*(7-4)");
        testExpressionString("1+2*3-1/2*2");
        testExpressionString("1+2+3*(1+2)/4");
        testExpressionString("1.2+2.3+3.4*(1.2+2.3)/4.5");
    }


    public void testExpressionString(String expression) {
        System.out.println("INPUT");
        System.out.println("Expression string: " + expression);
        Object expressionTree = ExpressionTree.createExpressionTree(expression);
        if (expressionTree instanceof ExpressionTree tree) {
            System.out.println("Expression tree: ");
            System.out.println(expressionTree);
            System.out.println("\nOUTPUT:");
            preorderPrint(tree);
            inorderPrint(tree);
            postorderPrint(tree);
        } else {
            System.out.println(expressionTree);
        }
        System.out.println("-".repeat(80));
    }

    public void preorderPrint(ExpressionTree expressionTree) {
        System.out.println("Pre-order:");
        expressionTree.preorderPrint(expressionTree.root());
        System.out.println();
    }

    public void inorderPrint(ExpressionTree expressionTree) {
        System.out.println("In-order:");
        expressionTree.inorderPrint(expressionTree.root());
        System.out.println();
    }

    public void postorderPrint(ExpressionTree expressionTree) {
        System.out.println("Post-order:");
        expressionTree.postorderPrint(expressionTree.root());
        System.out.println();
    }
}
