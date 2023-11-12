package hw5_21000506_nguyenthithanhhuong.ex02.task_b;

import hw5_21000506_nguyenthithanhhuong.ex02.task_a.ExpressionTree;

public class PrintExpressionFromExpressionTree {
    public static void print(ExpressionTree<String> tree) {
        // Input expression binary
        System.out.println("1. Input Expression Binary: ");
        System.out.println(tree.toString());

        // Print expression
        System.out.println("2. Print Expression: ");
        // pre-order print
        System.out.print("Pre-order print: ");
        preorderPrint(tree);
        System.out.println();
        // post-order print
        System.out.print("Post-order print: ");
        postorderPrint(tree);
        System.out.println();
        // in-order print
        System.out.print("In-order print: ");
        inorderPrint(tree);
    }

    public static void preorderPrint(ExpressionTree<String> tree) {
        tree.preorderPrint(tree.root());
    }

    public static void postorderPrint(ExpressionTree<String> tree) {
        tree.postorderPrint(tree.root());
    }

    public static void inorderPrint(ExpressionTree<String> tree) {
        tree.inorderPrint(tree.root());
    }
}
