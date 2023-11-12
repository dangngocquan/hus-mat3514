package hw5_21000689_nguyenxuanloi.practice.practice_1.ex65;

import hw5_21000689_nguyenxuanloi.practice.practice_1.LinkedBinaryTree;
import hw5_21000689_nguyenxuanloi.practice.practice_1.Node;

import java.util.Scanner;

public class CheckAVLTree {
    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        anyInput(sc, tree);
        sc.close();

        System.out.println(isAVLTree(tree, tree.root()));
    }

    static void stdInput(Scanner sc, int n, LinkedBinaryTree tree) {
        for (int i = 0; i < n; i++) {
            tree.setRoot(tree.insert(tree.root(), sc.nextInt()));
        }
    }

    static void anyInput(Scanner sc, LinkedBinaryTree tree) {
        sc.nextLine();
        String[] valuesInString = sc.nextLine().split("\\D+"); // input elements
        for (String s : valuesInString) {
            tree.setRoot(tree.insert(tree.root(), Integer.parseInt(s)));
        }
    }

    static boolean isAVLTree(LinkedBinaryTree tree, Node root) {
        if (root == null) {
            return true;
        } else {
            return (Math.abs(tree.height(root.getLeft()) - tree.height(root.getRight())) <= 1
                    && isAVLTree(tree, root.getLeft())
                    && isAVLTree(tree, root.getRight()));
        }
    }
}
