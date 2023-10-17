package hw5_21000699_dangngocquan.exercise001.c;

import hw5_21000699_dangngocquan.base.ArrayBinaryTree;
import hw5_21000699_dangngocquan.base.LinkedBinaryTree;

public class MyBuilder {
    public static ArrayBinaryTree<Integer> buildArrayBinaryTree() {
        ArrayBinaryTree<Integer> tree = createArrayBinaryTree();
        fillArrayBinaryTreeBySampleData(tree);
        return tree;
    }

    private static ArrayBinaryTree<Integer> createArrayBinaryTree() {
        return new ArrayBinaryTree<>();
    }

    private static void fillArrayBinaryTreeBySampleData(ArrayBinaryTree<Integer> tree) {
        tree.setRoot(1);
        Integer node1 = tree.root();
        tree.setLeft(node1, 5);
        tree.setRight(node1, 3);
        Integer node3 = tree.right(node1);
        Integer node5 = tree.left(node1);
        tree.setRight(node3, 7);
        tree.setLeft(node3, 2);
        tree.setRight(node5, 6);
        tree.setLeft(node5, 8);
    }

    public static LinkedBinaryTree<Integer> buildLinkedBinaryTree() {
        LinkedBinaryTree<Integer> tree = createLinkedBinaryTree();
        fillLinkedBinaryTreeBySampleData(tree);
        return tree;
    }

    private static LinkedBinaryTree<Integer> createLinkedBinaryTree() {
        return new LinkedBinaryTree<>();
    }

    private static void fillLinkedBinaryTreeBySampleData(LinkedBinaryTree<Integer> tree) {
        tree.addRoot(1);
        LinkedBinaryTree.LinkedBinaryTreeNode<Integer> node1 = tree.root();
        tree.addLeft(node1, 5);
        tree.addRight(node1, 3);
        LinkedBinaryTree.LinkedBinaryTreeNode<Integer> node3 = tree.right(node1);
        LinkedBinaryTree.LinkedBinaryTreeNode<Integer> node5 = tree.left(node1);
        tree.addRight(node3, 7);
        tree.addLeft(node3, 2);
        tree.addRight(node5, 6);
        tree.addLeft(node5, 8);
    }
}
