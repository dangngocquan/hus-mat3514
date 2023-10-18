package hw5_21000699_dangngocquan.exercise002.b;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;
import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

public class MyBuilder {
    public static ExpressionTree buildSampleExpressionTree() {
        ExpressionTree expressionTree = createExpressionTree();
        fillSampleDataTree(expressionTree);
        return expressionTree;
    }

    private static ExpressionTree createExpressionTree() {
        return new ExpressionTree();
    }

    private static void fillSampleDataTree(ExpressionTree tree) {
        tree.addRoot("*");
        LinkedBinaryTree.Node<String> node0 = tree.root();
        tree.addLeft(node0, "+");
        tree.addRight(node0, "-");
        LinkedBinaryTree.Node<String> node00 = tree.left(node0);
        LinkedBinaryTree.Node<String> node01 = tree.right(node0);
        tree.addLeft(node00, "/");
        tree.addRight(node00, "2");
        tree.addLeft(node01, "7");
        tree.addRight(node01, "4");
        LinkedBinaryTree.Node<String> node000 = tree.left(node00);
        tree.addLeft(node000, "6");
        tree.addRight(node000, "3");
    }
}
