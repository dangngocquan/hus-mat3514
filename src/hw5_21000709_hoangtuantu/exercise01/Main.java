package hw5_21000709_hoangtuantu.exercise01;

import java.util.Random;

public class Main {
    public static void test(boolean array, int size){

        Random random = new Random();
        if (array){
            ArrayBinaryTree<Integer, Integer> tree = ArrayBinaryTree.randomIntegerTree(size);

            System.out.println("Array way: ");
            System.out.println(tree);

            System.out.println("Print Pre-Order");
            tree.printPreOrder(0);
            System.out.println();
            System.out.println("Print In-Order");
            tree.printInOrder(0);
            System.out.println();
            System.out.println("Print Post-Order");
            tree.printPostOrder(0);
            System.out.println();
        }else {
            LinkedBinaryTree<Integer,Node<Integer>> tree = LinkedBinaryTree.randomIntegerTree(size);

            System.out.println("Print Pre-Order");
            tree.printPreOrder(tree.root());
            System.out.println();
            System.out.println("Print In-Order");
            tree.printInOrder(tree.root());
            System.out.println();
            System.out.println("Print Post-Order");
            tree.printPostOrder(tree.root());
            System.out.println();

            tree.printLevelOrder();
        }


    }
    public static void main(String[] args) {
        final int SIZE = 3;
        System.out.println("Test Array Tree: ");
        test(true, SIZE);

        System.out.println("_________________");
        System.out.println("Test Linked Tree");
        test(false, SIZE);
    }
}
