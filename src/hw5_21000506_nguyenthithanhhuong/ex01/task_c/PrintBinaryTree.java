package hw5_21000506_nguyenthithanhhuong.ex01.task_c;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.ArrayBinaryTree;
import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;

import java.io.*;

public class PrintBinaryTree {
    public static void main(String[] args) {
        // Create a tree by ArrayBinaryTree
        ArrayBinaryTree tree1 = new ArrayBinaryTree();
        tree1 = createTreeByArray();

        // Create a tree by LinkedBinaryTree
        LinkedBinaryTree tree2 = new LinkedBinaryTree<>();
        tree2 = createTreeByLinked();

        // Print tree
        System.out.println(printArrayBinaryTree(tree1));
        System.out.println(printLinkedBinaryTree(tree2));

        // Write result run program to file "output.txt"
        try {
            String pathFile = "src\\hw5_21000506_nguyenthithanhhuong\\ex01\\task_c\\output.txt";
            FileWriter fileWriter = new FileWriter(pathFile, true);
            OutputStream output = new FileOutputStream(pathFile);
            OutputStreamWriter outputWriter = new OutputStreamWriter(output);
            outputWriter.write(printArrayBinaryTree(tree1));
            outputWriter.write(printLinkedBinaryTree(tree2));
            outputWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create a tree by ArrayBinaryTree
    public static ArrayBinaryTree createTreeByArray() {
        ArrayBinaryTree tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        tree.setRight(1, 3);
        tree.setLeft(1, 5);
        tree.setRight(3, 7);
        tree.setLeft(3, 2);
        tree.setRight(2, 6);
        tree.setLeft(2, 8);
        return tree;
    }

    // Create a tree by LinkedBinaryTree
    public static LinkedBinaryTree createTreeByLinked() {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> nodeRoot = tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> nodeLeft0 = tree.addLeft(nodeRoot, 5);
        LinkedBinaryTree.Node<Integer> nodeRight1 = tree.addRight(nodeRoot, 3);
        LinkedBinaryTree.Node<Integer> nodeLeft00 = tree.addLeft(nodeLeft0, 8);
        LinkedBinaryTree.Node<Integer> nodeRight01 = tree.addRight(nodeLeft0, 6);
        LinkedBinaryTree.Node<Integer> nodeLeft10 = tree.addLeft(nodeRight1, 2);
        LinkedBinaryTree.Node<Integer> nodeRight11 = tree.addRight(nodeRight1, 7);
        return tree;
    }

    // Print a ArrayBinaryTree
    public static String printArrayBinaryTree(ArrayBinaryTree tree) {
        String res = "1. Binary tree created by ArrayBinaryTree: \n";
        return res + tree.toString();
    }

    // Print a linkedBinaryTree
    public static String printLinkedBinaryTree(LinkedBinaryTree tree) {
        String res = "2. Binary tree created by LinkedBinaryTree: \n";
        return res + tree.toString();
    }
}