package hw5_21000712_taquangtung.ex05;

/* Sách M. Goodrich, trang 358
P-8.69 Write a program that draws a binary tree.
 */

import hw5_21000712_taquangtung.ex01.ArrayBinaryTree;

public class DrawingBinaryTree {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ArrayBinaryTree<Integer, Integer> arrayTree = arrayBinaryTree(array);
        System.out.println("Draws a binary tree:");
        printRightRootLeft(arrayTree, 0, 0);
    }

    public static ArrayBinaryTree<Integer, Integer> arrayBinaryTree(int[] array) {
        ArrayBinaryTree<Integer, Integer> arrayTree = new ArrayBinaryTree<>();
        int size = (int) (Math.log(array.length) / Math.log(2)) + 1;

        int index = 0;
        int count = 0;

        arrayTree.setRoot(array[0]);

        while (index < array.length) {
            int leftIdx = index * 2 + 1;
            int rightIdx = index * 2 + 2;

            if (leftIdx < array.length) {
                arrayTree.setLeft(index, array[leftIdx]);
            }

            if (rightIdx < array.length) {
                arrayTree.setRight(index, array[rightIdx]);
            }

            index++;
            count++;

            if (count > size) {
                break;
            }
        }
        return arrayTree;
    }

    public static void printRightRootLeft(ArrayBinaryTree<Integer, Integer> tree, int currentIndex, int level) {
        if (currentIndex < tree.size()) {

            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            printRightRootLeft(tree, rightChildIndex, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(tree.getElementOfNode(currentIndex));
            printRightRootLeft(tree, leftChildIndex, level + 1);
        }
    }
}
