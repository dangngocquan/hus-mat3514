package hw5_21000689_nguyenxuanloi.exercise.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformTree {
    public static void main(String[] args) {
        test();
        customTest();
    }

    static void test() {
        LinkedTree<Integer> tree = new LinkedTree<>();
        tree.addRoot(8);

        tree.addChild(tree.root(), 1, 3, 9);

        tree.addChild(findNode(tree.root(), 1), 0, 2, 7);
        tree.addChild(findNode(tree.root(), 3), 4);

        tree.addChild(findNode(tree.root(), 0), 5);

        tree.addChild(findNode(tree.root(), 5), 6);

        tree.print();

        transform(tree, 0);
        tree.print();

        LinkedTree<Integer> anotherTree = new LinkedTree<>();
        anotherTree.addRoot(1);

        anotherTree.addChild(anotherTree.root(), 5, 3);

        anotherTree.addChild(findNode(anotherTree.root(), 5), 8, 6);
        anotherTree.addChild(findNode(anotherTree.root(), 3), 2, 7);

        anotherTree.print();
        transform(anotherTree, 7);
        anotherTree.print();
    }
    static void customTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter parent - child pair with integer values:");
        LinkedTree<Integer> tree = new LinkedTree<>();
        String line = sc.nextLine();
        while (!line.isEmpty()) {
            String[] pair = line.split("\\s*-\\s*");
            if (tree.root() == null) {
                tree.addRoot(Integer.parseInt(pair[0]));
                tree.addChild(tree.root(), Integer.parseInt(pair[1]));
            } else {
                TreeNode<Integer> p = findNode(tree.root(), Integer.parseInt(pair[0]));
                if (p != null) {
                    tree.addChild(p, Integer.parseInt(pair[1]));
                } else {
                    System.out.println("Parent isn't already in the tree.");
                }
            }
            line = sc.nextLine();
        }

        System.out.print("Choose element to set it as new root: ");
        int value = sc.nextInt();
        sc.close();

        transform(tree, value);
        tree.print();
    }

    static <E> void transform(LinkedTree<E> tree, E element) {
        if (element != tree.root().getElement()) {
            TreeNode<E> newRoot = findNode(tree.root(), element);
            if (newRoot != null) {
                TreeNode<E> temp = newRoot;
                int d = tree.depth(temp);
                List<TreeNode<E>> nodes = new ArrayList<>();
                nodes.add(temp);
                for (int i = 1; i < d; i++) {
                    temp.getChild().add(temp.getParent());
                    temp.getParent().getChild().remove(temp);
                    temp = temp.getParent();
                    nodes.add(temp);
                }
                for (int i = nodes.size() - 1; i > 0; i--) {
                    nodes.get(i).setParent(nodes.get(i - 1));
                }
                newRoot.setParent(null);
                tree.setRoot(newRoot);
            } else {
                System.out.println("Element isn't in the tree.");
            }
        }
    }

    static <E> TreeNode<E> findNode(TreeNode<E> root, E element) {
        if (root == null || root.getElement() == null) {
            return null;
        }
        if (root.getElement().equals(element)) {
            return root;
        }
        if (root.getChild() != null) {
            for (int i = 0; i < root.getChild().size(); i++) {
                TreeNode<E> node = findNode(root.getChild().get(i), element);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }
}
