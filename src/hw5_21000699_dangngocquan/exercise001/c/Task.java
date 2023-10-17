package hw5_21000699_dangngocquan.exercise001.c;

import hw5_21000699_dangngocquan.base.ArrayBinaryTree;
import hw5_21000699_dangngocquan.base.LinkedBinaryTree;

public class Task {
    public void run() {
        // ARRAY BINARY TREE
        System.out.println("\nARRAY BINARY TREE");
        ArrayBinaryTree<Integer> arrayBinaryTree = MyBuilder.buildArrayBinaryTree();
        MyPrinter.printBinaryTree(arrayBinaryTree);
        /*

              7
           3
              2
        1
              6
           5
              8

        */
        MyWriter.writeToFile(arrayBinaryTree);

        // LINKED BINARY TREE
        System.out.println("\nLINKED BINARY TREE");
        LinkedBinaryTree<Integer> linkedBinaryTree = MyBuilder.buildLinkedBinaryTree();
        MyPrinter.printBinaryTree(linkedBinaryTree);
        /*

              7
           3
              2
        1
              6
           5
              8

        */
        MyWriter.writeToFile(linkedBinaryTree);

    }
}
