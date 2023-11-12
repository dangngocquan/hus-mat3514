package hw5_22001273_nguyenhoangminh.excercise2;

import hw5_22001273_nguyenhoangminh.excercise1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree {

    public double calculate(Node<E> root) {
        if (root == null) return 0.0;

        if (root.getLeft() == null && root.getRight() == null) {
            return Double.parseDouble(Character.toString((char) root.getElement()));
        }

        double a = calculate(root.getLeft());

        double b = calculate(root.getRight());

        if (root.getElement().equals('+')) return a + b;
        else if (root.getElement().equals('-')) return a - b;
        else if (root.getElement().equals('*')) return a * b;
        else return a / b;
    }
    public void inorderPrint(Node<E> root) {
        if (root == null) return;

        inorderPrint(root.getLeft());

        System.out.print(root.getElement() + " ");

        inorderPrint(root.getRight());
    }

    public void preorderPrint(Node<E> root) {
        if (root == null) return;

        System.out.print(root.getElement() + " ");

        preorderPrint(root.getLeft());

        preorderPrint(root.getRight());
    }

    public void postorderPrint(Node<E> root) {
        if (root == null) return;

        System.out.print(root.getElement() + " ");

        postorderPrint(root.getLeft());

        postorderPrint(root.getRight());
    }
}
