package hw5_21000699_dangngocquan.exercise002.c;

import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;
import hw5_21000699_dangngocquan.exercise002.b.MyBuilder;

public class Test {
    public void run() {
        ExpressionTree expressionTree = createSampleExpressionTree();
        evaluate(expressionTree);
    }

    public ExpressionTree createSampleExpressionTree() {
        ExpressionTree expressionTree = MyBuilder.buildSampleExpressionTree();
        System.out.println("INPUT:");
        System.out.println(expressionTree);
        return expressionTree;
    }

    public void evaluate(ExpressionTree expressionTree) {
        System.out.println("\n\nOUTPUT: ");
        System.out.println(expressionTree.evaluateToString());
    }
}
