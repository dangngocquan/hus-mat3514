package hw5_21000506_nguyenthithanhhuong.ex01.task_a;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.ArrayBinaryTree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        // Create a tree
        ArrayBinaryTree tree = new ArrayBinaryTree();
        createArrayBinaryTree(tree);

        // Print input tree
        System.out.println("1. Input Binary Tree: ");
        System.out.println(tree.toString());

        // Test ArrayBinaryTree
        System.out.println("2. Test Array Binary Tree:");
        test(tree);
    }

    // Create a tree by ArrayBinaryTree
    public static void createArrayBinaryTree(ArrayBinaryTree tree) {
        tree.setRoot(10);
        tree.setRight(1, 18);
        tree.setLeft(1, 12);
        tree.setRight(3, 20);
        tree.setLeft(3, 3);
        tree.setRight(2, 15);
        tree.setLeft(2, 9);
    }

    // Test case
    public static void test(ArrayBinaryTree tree) {
        System.out.printf("2.1 Test root(): %d\n", tree.root());

        System.out.printf("2.2 Test size(): %d\n", tree.size());

        System.out.printf("2.3 Test isEmpty(): %s\n", tree.isEmpty());

        System.out.println("2.4 Test level(): ");
        System.out.printf("\tlevel(2): %d\n", tree.level(2));
        System.out.printf("\tlevel(6): %d\n", tree.level(6));

        System.out.println("2.5 Test numChildren(): ");
        System.out.printf("\tnumChildren(0): %d\n", tree.numChildren(0));
        System.out.printf("\tnumChildren(2): %d\n", tree.numChildren(2));
        System.out.printf("\tnumChildren(4): %d\n", tree.numChildren(4));

        System.out.println("2.6 Test parent(): ");
        System.out.printf("\tparent(1): %d\n", tree.parent(1));
        System.out.printf("\tparent(5): %d\n", tree.parent(5));
        System.out.printf("\tparent(6): %d\n", tree.parent(6));

        System.out.println("2.7 Test left(): ");
        System.out.printf("\tleft(2): %d\n", tree.left(2));
        System.out.printf("\tleft(4): %d\n", tree.left(4));

        System.out.println("2.8 Test right(): ");
        System.out.printf("\tright(1): %d\n", tree.right(1));
        System.out.printf("\tright(3): %d\n", tree.right(3));

        System.out.println("2.9 Test sibling: ");
        System.out.printf("\tsibling(4): %d\n", tree.sibling(4));
        System.out.printf("\tsibling(1): %d\n", tree.sibling(1));
    }
}

//    Result test:
//    1. Input Binary Tree:
//          20
//       18
//          3
//    10
//          15
//       12
//          9
//
//    2. Test Array Binary Tree:
//    2.1 Test root(): 1
//    2.2 Test size(): 7
//    2.3 Test isEmpty(): false
//    2.4 Test level():
//        level(2): 2
//        level(6): 3
//    2.5 Test numChildren():
//        numChildren(0): -1
//        numChildren(2): 2
//        numChildren(4): 0
//    2.6 Test parent():
//        parent(1): -1
//        parent(5): 2
//        parent(6): 3
//    2.7 Test left():
//        left(2): 4
//        left(4): -1
//    2.8 Test right():
//        right(1): 3
//        right(3): 7
//    2.9 Test sibling:
//        sibling(4): 5
//        sibling(1): -1