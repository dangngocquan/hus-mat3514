package hw5_21000712_taquangtung.ex01;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 6, 2, 7};
        ArrayBinaryTree<Integer, Integer> arrayTree = arrayBinaryTreeTXT(array);
        System.out.println("Tree structure by ArrayBinaryTree:");
        printRightRootLeft(arrayTree, 0, 0);

        writeTreeToFile(arrayTree, "D:/MAT3514_CTDLTT/DSA/src/Hw5_21000712_TaQuangTung/ex01/output1.txt");
    }

    public static ArrayBinaryTree<Integer, Integer> arrayBinaryTreeTXT(int[] array) {
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

    // Vẽ cây trên Terminal
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

    // Lưu vào file output1.txt
    public static void printRightRootLeft(ArrayBinaryTree<Integer, Integer> tree, int currentIndex, int level, BufferedWriter writer) throws IOException {
        FileWriter fw = new FileWriter("D:/MAT3514_CTDLTT/DSA/src/Hw5_21000712_TaQuangTung/ex01/output1.txt");
        fw.write("Tree structure by ArrayBinaryTree:\n");
        fw.close();

        if (currentIndex < tree.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            printRightRootLeft(tree, rightChildIndex, level + 1, writer);

            try {

                for (int i = 0; i < level; i++) {
                    writer.write("    ");
                }
                writer.write(tree.getElementOfNode(currentIndex).toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            printRightRootLeft(tree, leftChildIndex, level + 1, writer);
        }
    }

    public static void writeTreeToFile(ArrayBinaryTree<Integer, Integer> tree, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            printRightRootLeft(tree, 0, 0,  writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
