package hw7_21000699_dangngocquan.exercise003;

public class Test {
    public void run() {
        testBinarySearchTree();
    }

    public void testBinarySearchTree() {
        System.out.println("TEST AVL BINARY SEARCH TREE\n");
        System.out.printf(
                "%-25s %-15s %s\n",
                "Method",
                "Return",
                "Binary Search Tree"
        );
        System.out.println("-".repeat(90));

        AVLBinarySearchTree<Integer> tree = new AVLBinarySearchTree<>();
        testInsert(tree, 10);
        testInsert(tree, 5);
        testInsert(tree, 2);
        testInsert(tree, 1);
        testInsert(tree, 3);
        testInsert(tree, 4);
        testInsert(tree, 15);
        testInsert(tree, 20);
        testInsert(tree, 19);
        testInsert(tree, 18);
        testInsert(tree, 17);
    }

    public void testInsert(AVLBinarySearchTree<Integer> tree, Integer value) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "insert(value=" + value + ")",
                tree.insert(value),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }
}
