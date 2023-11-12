package hw5_22001273_nguyenhoangminh.luyentap11;

import hw5_22001273_nguyenhoangminh.excercise1.LinkedBinaryTree;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree = new LinkedBinaryTree<>();

        tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> root = tree.root();

        LinkedBinaryTree.Node<Integer> l = tree.addLeft(root, 2);
        LinkedBinaryTree.Node<Integer> r = tree.addRight(root, 3);

        LinkedBinaryTree.Node<Integer> l1 = tree.addLeft(l, 4);
        LinkedBinaryTree.Node<Integer> l2 = tree.addRight(l, 5);

        LinkedBinaryTree.Node<Integer> r1 = tree.addLeft(r, 6);
        LinkedBinaryTree.Node<Integer> r2 = tree.addRight(r, 7);

        tree.print(root, 0);

        System.out.println("Print In-order:");
        tree.inOrder(root);
    }
}
