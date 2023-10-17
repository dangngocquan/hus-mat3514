package hw5_21000699_dangngocquan.exercise001.b;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;

public class Test {
    public void run() {
        System.out.println("TEST LINKED BINARY TREE\n");
        System.out.printf(
                "%-25s %-15s %s\n",
                "Method",
                "Return",
                "Binary Tree"
        );
        System.out.println("-".repeat(90));

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        root(tree);
        size(tree);
        isEmpty(tree);
        numberChildren(tree, tree.root());
        addRoot(tree, "A");
        LinkedBinaryTree.LinkedBinaryTreeNode<String> nodeA = tree.root(); // save to use later
        addLeft(tree, nodeA, "A0");
        LinkedBinaryTree.LinkedBinaryTreeNode<String> nodeA0 = tree.left(nodeA); // save to use later
        addRight(tree, nodeA, "A1");
        LinkedBinaryTree.LinkedBinaryTreeNode<String> nodeA1 = tree.right(nodeA); // save to use later
        element(tree, nodeA);
        element(tree, nodeA0);
        element(tree, nodeA1);
        root(tree);
        size(tree);
        isEmpty(tree);
        numberChildren(tree, nodeA);
        parent(tree, nodeA0);
        parent(tree, nodeA1);
        left(tree, nodeA);
        right(tree, nodeA);
        sibling(tree, nodeA0);
        sibling(tree, nodeA1);
        addLeft(tree, nodeA0, "A00");
        LinkedBinaryTree.LinkedBinaryTreeNode<String> nodeA00 = tree.left(nodeA0); // save to use later
        addLeft(tree, nodeA1, "A10");
        addRight(tree, nodeA0, "A01");
        size(tree);
        addLeft(tree, nodeA00, "A000");
        size(tree);
        addLeft(tree, nodeA, null);
        size(tree);
    }

    public void root(LinkedBinaryTree<String> tree) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "root()",
                tree.root(),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void size(LinkedBinaryTree<String> tree) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "size()",
                tree.size(),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void isEmpty(LinkedBinaryTree<String> tree) {
        System.out.printf(
                "%-25s %-15s %s\n",
                "isEmpty()",
                tree.isEmpty(),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void numberChildren(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("numberChildren(%s)", p),
                tree.numberChildren(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void element(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("element(%s)", p),
                tree.element(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void parent(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("parent(%s)", p),
                tree.parent(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void left(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("left(%s)", p),
                tree.left(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void right(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("right(%s)", p),
                tree.right(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void sibling(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("sibling(%s)", p),
                tree.sibling(p),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void addRoot(
            LinkedBinaryTree<String> tree, String element) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("setRoot(%s)", element),
                tree.addRoot(element),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void addLeft(
            LinkedBinaryTree<String> tree,
            LinkedBinaryTree.LinkedBinaryTreeNode<String> p, String element) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("setLeft(%s, %s)", p, element),
                tree.addLeft(p, element),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }

    public void addRight(
            LinkedBinaryTree<String> tree, LinkedBinaryTree.LinkedBinaryTreeNode<String> p, String element) {
        System.out.printf(
                "%-25s %-15s %s\n",
                String.format("setRight(%s, %s)", p, element),
                tree.addRight(p, element),
                tree.toString().replace("\n", "\n" + " ".repeat(42))
        );
        System.out.println("-".repeat(90));
    }
}
