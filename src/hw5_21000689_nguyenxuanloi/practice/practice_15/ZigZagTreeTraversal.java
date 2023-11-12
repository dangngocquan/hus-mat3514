package hw5_21000689_nguyenxuanloi.practice.practice_15;

import java.util.Stack;

public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);

        tree.addLeft(tree.root(), 2);
        tree.addRight(tree.root(), 3);

        tree.addLeft(tree.root().getLeft(), 4);
        tree.addRight(tree.root().getLeft(), 5);
        tree.addLeft(tree.root().getRight(), 6);
        tree.addRight(tree.root().getRight(), 7);

        tree.addLeft(tree.root().getLeft().getLeft(), 8);
        tree.addRight(tree.root().getLeft().getLeft(), 9);
        tree.addLeft(tree.root().getLeft().getRight(), 10);
        tree.addRight(tree.root().getLeft().getRight(), 11);
        tree.addLeft(tree.root().getRight().getLeft(), 12);
        tree.addRight(tree.root().getRight().getLeft(), 13);
        tree.addLeft(tree.root().getRight().getRight(), 14);
        tree.addRight(tree.root().getRight().getRight(), 15);

        traverseTree(tree);
    }

    static <E> void traverseTree(LinkedBinaryTree<E> tree) {
        if (tree.size() == 0) {
            System.out.println("Tree is empty.");
        } else {
            System.out.println("ZigZag order: ");
            if (height(tree.root()) == 1) {
                System.out.println(tree.root().getElement());
            } else {
                Stack<Node<E>> currentLevel = new Stack<>();
                currentLevel.add(tree.root());
                Stack<Node<E>> nextLevel = new Stack<>();

                for (int i = 1; i <= height(tree.root()); i++) {
                    while (!currentLevel.isEmpty()) {
                        if (i % 2 == 1) {
                            if (currentLevel.peek().getLeft() != null) {
                                nextLevel.add(currentLevel.peek().getLeft());
                            }
                            if (currentLevel.peek().getRight() != null) {
                                nextLevel.add(currentLevel.peek().getRight());
                            }
                        } else {
                            if (currentLevel.peek().getRight() != null) {
                                nextLevel.add(currentLevel.peek().getRight());
                            }
                            if (currentLevel.peek().getLeft() != null) {
                                nextLevel.add(currentLevel.peek().getLeft());
                            }
                        }
                        System.out.print(currentLevel.pop().getElement() + " ");
                    }

                    currentLevel.addAll(nextLevel);
                    nextLevel.clear();
                }
            }
        }
    }

    static <E> int height(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }
}
