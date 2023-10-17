package hw5_21000699_dangngocquan.exercise002.b;

import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

public class Test {
    public void run() {
        ExpressionTree expressionTree = createSampleExpressionTree();
        System.out.println("\nOUTPUT:");
        preorderPrint(expressionTree);
        inorderPrint(expressionTree);
        postorderPrint(expressionTree);
    }

    public ExpressionTree createSampleExpressionTree() {
        ExpressionTree expressionTree = MyBuilder.buildSampleExpressionTree();
        System.out.println("INPUT:");
        System.out.println(expressionTree);
        return expressionTree;
    }

    public void preorderPrint(ExpressionTree expressionTree) {
        System.out.println("\nPre-order:");
        expressionTree.preorderPrint(expressionTree.root());
    }

    public void inorderPrint(ExpressionTree expressionTree) {
        System.out.println("\nIn-order:");
        expressionTree.inorderPrint(expressionTree.root());
    }

    public void postorderPrint(ExpressionTree expressionTree) {
        System.out.println("\nPost-order:");
        expressionTree.postorderPrint(expressionTree.root());
    }
}
