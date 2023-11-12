package hw5_22001273_nguyenhoangminh.excercise2;

import hw5_22001273_nguyenhoangminh.excercise1.LinkedBinaryTree.Node;

public class TestMain {
    public static void main(String[] args) {
        ExpressionTree<Character> expressionTree = new ExpressionTree<>();

        expressionTree.addRoot('*');
        Node<Character> root = (Node<Character>) expressionTree.root();

        Node<Character> l = expressionTree.addLeft(root, '+');
            Node<Character> l1 = expressionTree.addLeft(l, '/');
                Node<Character> l11 = expressionTree.addLeft(l1, '6');
                Node<Character> l12 = expressionTree.addRight(l1, '3');
            Node<Character> l2 = expressionTree.addRight(l, '2');

        Node<Character> r = expressionTree.addRight(root, '-');
            Node<Character> r1 = expressionTree.addLeft(r, '7');
            Node<Character> r2 = expressionTree.addRight(r, '4');

        System.out.println("Pre-order:");
        expressionTree.preorderPrint(root);
        System.out.println();
        System.out.println("In-order:");
        expressionTree.inorderPrint(root);
        System.out.println();
        System.out.println("Post-order:");
        expressionTree.postorderPrint(root);
        System.out.println();
        System.out.println("Result: " + expressionTree.calculate(root));
    }
}
