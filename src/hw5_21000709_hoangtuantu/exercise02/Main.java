package hw5_21000709_hoangtuantu.exercise02;

import hw5_21000709_hoangtuantu.exercise01.LinkedBinaryTree;
import hw5_21000709_hoangtuantu.exercise01.Node;

public class Main {
    public static LinkedBinaryTree<String, Node<String> > create(){
        LinkedBinaryTree<String, Node<String>> tree = new LinkedBinaryTree<>();
        tree.addRoot("*");
        tree.addLeft(tree.root(), "+");
        tree.addRight(tree.root(), "-");

        tree.addLeft(tree.root().left, "/");
        tree.addRight(tree.root().left, "3");

        tree.addLeft(tree.root().left.left, "6");
        tree.addRight(tree.root().left.left, "2");


        tree.addLeft(tree.root().right, "7");
        tree.addRight(tree.root().right, "4");
        return tree;
    }
    public static void main(String[] args) {
        Node<String> root = create().root();
        ExpressionTree<String> expression = new ExpressionTree<>(root);
        System.out.println("Print Pre-order:");
        expression.preorderPrint();

        System.out.println("\nPrint in-order: ");
        expression.inorderPrint();

        System.out.println("\nPrint post-order: ");
        expression.postorderPrint();

        System.out.println();

        System.out.println("Value of expression: " + expression.evaluateExpressionTree(root));
    }
}
