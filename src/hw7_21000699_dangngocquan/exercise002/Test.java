package hw7_21000699_dangngocquan.exercise002;

import hw7_21000699_dangngocquan.exercise001.Generator;

public class Test {
    public void run() {
        testBinarySearchTree();
        testSearchRunTime(100000);
        testSearchRunTime(1000000);
        testSearchRunTime(10000000);
        testSearchRunTime(100000000);
    }

    public void testBinarySearchTree() {
        System.out.println("TEST BINARY SEARCH TREE\n");
        System.out.printf(
                "%-25s %-15s %s\n",
                "Method",
                "Return",
                "Binary Search Tree"
        );
        System.out.println("-".repeat(90));

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        testInsert(tree, 5);
        testInsert(tree, 6);
        testInsert(tree, 4);
        testInsert(tree, 3);
        testFindMin(tree);
        testSearch(tree, 5);
        testSearch(tree, 7);
        testDelete(tree, 6);
        testInsert(tree, 1);
        testInsert(tree, 2);
        testInsert(tree, 7);
        testInsert(tree, 6);
        testDelete(tree, 1);
    }

    public void testFindMin(BinarySearchTree<Integer> tree) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "findMin()",
                tree.findMin(),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void testSearch(BinarySearchTree<Integer> tree, Integer value) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "search(value=" + value + ")",
                tree.search(value),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void testInsert(BinarySearchTree<Integer> tree, Integer value) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "insert(value=" + value + ")",
                tree.insert(value),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void testDelete(BinarySearchTree<Integer> tree, Integer value) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "delete(value=" + value + ")",
                tree.delete(value),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void testSearchRunTime(int n) {
        Integer x = new Generator().randomInteger(0, n);
        RunTimeCalculator runtime = new RunTimeCalculator();
        System.out.println("\nTEST SEARCH n = " + n);
        System.out.println("Sequential search with array: " + runtime.sequentialSearchWithArray(n, x) + "ms");
        System.out.println("Binary search with sorted array: " + runtime.binarySearchWithSortedArray(n, x) + "ms");
        try {
            System.out.println("Search with Binary Search Tree: " + runtime.searchInBinarySearchTree(n, x) + "ms");
        } catch (OutOfMemoryError e) {
            System.out.println("Search with Binary Search Tree: " + "Out of memory when creating sample");
        }
    }
}
