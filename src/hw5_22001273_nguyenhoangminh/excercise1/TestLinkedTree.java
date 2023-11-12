package hw5_22001273_nguyenhoangminh.excercise1;

import hw5_22001273_nguyenhoangminh.excercise1.LinkedBinaryTree.Node;

public class TestLinkedTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, Node<Integer>> tree = new LinkedBinaryTree<>();

        tree.addRoot(1);
        Node<Integer> root = tree.root();

        Node<Integer> l = tree.addLeft(root, 2);
        Node<Integer> r = tree.addRight(root, 3);

        Node<Integer> l1 = tree.addLeft(l, 4);
        Node<Integer> l2 = tree.addRight(l, 5);

        Node<Integer> r1 = tree.addLeft(r, 6);
        Node<Integer> r2 = tree.addRight(r, 7);

        tree.print(root, 0);
    }
}