package hw5_21000506_nguyenthithanhhuong.ex02.task_b;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;
import hw5_21000506_nguyenthithanhhuong.ex02.task_a.ExpressionTree;

public class Test {
    public static void main(String[] args) {
        // Create test expression tree
        LinkedBinaryTree tree = createTestExpressionTree();
        ExpressionTree<String> tree1 = new ExpressionTree<>(tree);

        // Print expression
        PrintExpressionFromExpressionTree.print(tree1);
    }

    // Create test expression tree
    public static LinkedBinaryTree createTestExpressionTree() {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        LinkedBinaryTree.Node<String> nodeRoot = tree.addRoot("*");
        LinkedBinaryTree.Node<String> nodeLeft0 = tree.addLeft(nodeRoot, "+");
        LinkedBinaryTree.Node<String> nodeRight1 = tree.addRight(nodeRoot, "-");
        LinkedBinaryTree.Node<String> nodeLeft00 = tree.addLeft(nodeLeft0, "/");
        LinkedBinaryTree.Node<String> nodeRight01 = tree.addRight(nodeLeft0, "2");
        LinkedBinaryTree.Node<String> nodeLeft10 = tree.addLeft(nodeRight1, "7");
        LinkedBinaryTree.Node<String> nodeRight11 = tree.addRight(nodeRight1, "4");
        LinkedBinaryTree.Node<String> nodeLeft000 = tree.addLeft(nodeLeft00, "6");
        LinkedBinaryTree.Node<String> nodeRight001 = tree.addRight(nodeLeft00, "3");

        return tree;
    }
}
//    Result test
//    1. Input Expression Binary:
//          4
//       -
//          7
//    *
//          2
//       +
//             3
//          /
//             6
//
//    2. Print Expression:
//    Pre-order print: * + / 6 3 2 - 7 4
//    Post-order print: 6 3 / 2 + 7 4 - *
//    In-order print: (((6 / 3 )+ 2 )* (7 - 4 ))