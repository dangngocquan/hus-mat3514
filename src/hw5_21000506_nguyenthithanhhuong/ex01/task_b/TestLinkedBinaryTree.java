package hw5_21000506_nguyenthithanhhuong.ex01.task_b;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;

public class TestLinkedBinaryTree {
    public static void main(String[] args) {
        // Create a tree by LinkedBinaryTree
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        LinkedBinaryTree.Node<Integer> nodeRoot = tree.addRoot(10);
        LinkedBinaryTree.Node<Integer> nodeLeft0 = tree.addLeft(nodeRoot, 12);
        LinkedBinaryTree.Node<Integer> nodeRight1 = tree.addRight(nodeRoot, 18);
        LinkedBinaryTree.Node<Integer> nodeLeft00 = tree.addLeft(nodeLeft0, 9);
        LinkedBinaryTree.Node<Integer> nodeRight01 = tree.addRight(nodeLeft0, 15);
        LinkedBinaryTree.Node<Integer> nodeLeft10 = tree.addLeft(nodeRight1, 20);
        LinkedBinaryTree.Node<Integer> nodeRight11 = tree.addRight(nodeRight1, 3);

        // Print input tree
        System.out.println("1. Input Binary Tree: ");
        System.out.println(tree.toString());

        // Test LinkedBinaryTree
        System.out.println("2. Test Array Binary Tree:");
        System.out.printf("2.1 Test root(): %s\n", tree.root().getElement());

        System.out.printf("2.2 Test size(): %d\n", tree.size());

        System.out.printf("2.3 Test isEmpty(): %s\n", tree.isEmpty());

        System.out.println("2.4 Test level(): ");
        System.out.printf("\tlevel(nodeLeft0): %d\n", tree.level(nodeLeft0));
        System.out.printf("\tlevel(nodeLeft10): %d\n", tree.level(nodeLeft10));

        System.out.println("2.5 Test numChildren(): ");
        System.out.printf("\tnumChildren(nodeRoot): %d\n", tree.numChildren(nodeRoot));
        System.out.printf("\tnumChildren(nodeLeft0): %d\n", tree.numChildren(nodeLeft0));
        System.out.printf("\tnumChildren(nodeLeft00): %d\n", tree.numChildren(nodeLeft00));

        System.out.println("2.6 Test parent(): ");
        System.out.printf("\tparent(nodeRight01): %s\n", tree.parent(nodeRight01).getElement());
        System.out.printf("\tparent(nodeLeft10): %s\n", tree.parent(nodeLeft10).getElement());

        System.out.println("2.7 Test left(): ");
        System.out.printf("\tleft(nodeLeft0): %s\n", tree.left(nodeLeft0).getElement());
        System.out.printf("\tleft(nodeRight1): %s\n", tree.left(nodeRight1).getElement());

        System.out.println("2.8 Test right(): ");
        System.out.printf("\tright(nodeRoot): %s\n", tree.right(nodeRoot).getElement());
        System.out.printf("\tright(nodeRight1): %s\n", tree.right(nodeRight1).getElement());

        System.out.println("2.9 Test sibling: ");
        System.out.printf("\tsibling(nodeLeft00): %s\n", tree.sibling(nodeLeft00).getElement());
        System.out.printf("\tsibling(nodeRight11): %s\n", tree.sibling(nodeRight11).getElement());
    }
}

//    Result test:
//    1. Input Binary Tree:
//                3
//          18
//                20
//    10
//                15
//          12
//                9
//
//    2. Test Array Binary Tree:
//    2.1 Test root(): 10
//    2.2 Test size(): 7
//    2.3 Test isEmpty(): false
//    2.4 Test level():
//        level(nodeLeft0): 2
//        level(nodeLeft10): 3
//    2.5 Test numChildren():
//        numChildren(nodeRoot): 2
//        numChildren(nodeLeft0): 2
//        numChildren(nodeLeft00): 0
//    2.6 Test parent():
//        parent(nodeRight01): 12
//        parent(nodeLeft10): 18
//    2.7 Test left():
//        left(nodeLeft0): 9
//        left(nodeRight1): 20
//    2.8 Test right():
//        right(nodeRoot): 18
//        right(nodeRight1): 3
//    2.9 Test sibling:
//        sibling(nodeLeft00): 15
//        sibling(nodeRight11): 20