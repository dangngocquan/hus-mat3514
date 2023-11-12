package hw5_21000506_nguyenthithanhhuong.ex02.task_c;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;
import hw5_21000506_nguyenthithanhhuong.ex02.task_a.ExpressionTree;

public class Test {
    public static void main(String[] args) {
        // Create expression tree
        LinkedBinaryTree tree = createTestExpressionTree();
        ExpressionTree<String> tree1 = new ExpressionTree<>(tree);

        // Print input expression tree
        System.out.println("1. Input expression tree: ");
        System.out.println(tree1.toString());

        // Print result (evaluate expression from expression tree)
        System.out.println("2. Result: ");
        System.out.println(tree1.evaluateExpressionTree(tree1.root()));;
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

//    Result
//    1. Input expression tree:
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
//    2. Result:
//    12.0
