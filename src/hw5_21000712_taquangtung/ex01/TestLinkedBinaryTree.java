package hw5_21000712_taquangtung.ex01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestLinkedBinaryTree {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 6, 2, 7};
        LinkedBinaryTree<LinkedBinaryTree.Node, Integer> linkedTree = linkedBinaryTreeTXT(array);

        System.out.println("Tree structure by LinkedBinaryTree:");
        printRightRootLeft(linkedTree, 0, 0, array);

        writeTreeToFile(linkedTree, array, "D:/MAT3514_CTDLTT/DSA/src/Hw5_21000712_TaQuangTung/ex01/output2.txt");

    }

    public static LinkedBinaryTree<LinkedBinaryTree.Node, Integer> linkedBinaryTreeTXT(int[] array) {
        LinkedBinaryTree<LinkedBinaryTree.Node, Integer> linkedTree = new LinkedBinaryTree<>();
        int sizeTree = (int) (Math.log(array.length) / Math.log(2)) + 1;

        int index = 0;
        int count = 0;

        LinkedBinaryTree.Node rootNode = new LinkedBinaryTree.Node(array[0], null, null, null);
        linkedTree.addRoot(rootNode);

        while (index < array.length) {
            int leftIdx = index * 2 + 1;
            int rightIdx = index * 2 + 2;

            LinkedBinaryTree.Node currentNode = new LinkedBinaryTree.Node<>(array[index], null, null, null);

            if (leftIdx < array.length) {
                LinkedBinaryTree.Node leftValue = new LinkedBinaryTree.Node<>(array[leftIdx], null, null, null);
                linkedTree.addLeft(currentNode, leftValue);
            }

            if (rightIdx < array.length) {
                LinkedBinaryTree.Node rightValue = new LinkedBinaryTree.Node<>(array[rightIdx], null, null, null);
                linkedTree.addRight(currentNode, rightValue);
            }

            index++;
            count++;

            if (count == sizeTree) {
                break;
            }
        }

        return linkedTree;
    }


    // Vẽ cây trên Terminal
    public static void printRightRootLeft(LinkedBinaryTree<LinkedBinaryTree.Node, Integer> tree, int currentIndex, int level, int[] array) {
        if (currentIndex < tree.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            printRightRootLeft(tree, rightChildIndex, level + 1, array);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(array[currentIndex]);
            printRightRootLeft(tree, leftChildIndex, level + 1, array);
        }
    }

    // Lưu vào file output2.txt
    public static void printRightRootLeft(LinkedBinaryTree<LinkedBinaryTree.Node, Integer> tree, int currentIndex, int level, int[] array, BufferedWriter writer) throws IOException {
        FileWriter fw = new FileWriter("D:/MAT3514_CTDLTT/DSA/src/Hw5_21000712_TaQuangTung/ex01/output2.txt");
        fw.write("Tree structure by LinkedBinaryTree:\n");
        fw.close();

        if (currentIndex < tree.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            printRightRootLeft(tree, rightChildIndex, level + 1, array, writer);

            try {
                for (int i = 0; i < level; i++) {
                    writer.write("    ");
                }
                String elementWrite = String.valueOf(array[currentIndex]);
                writer.write(elementWrite);
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            printRightRootLeft(tree, leftChildIndex, level + 1, array, writer);
        }
    }

    public static void writeTreeToFile(LinkedBinaryTree<LinkedBinaryTree.Node, Integer> tree, int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            printRightRootLeft(tree, 0, 0, array, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
