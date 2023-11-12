package hw5_21000506_nguyenthithanhhuong.ex02.task_a;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree {
    private LinkedBinaryTree<String, Node> tree;

    public ExpressionTree(LinkedBinaryTree<String, Node> linkedBinaryTree) {
        tree = linkedBinaryTree;
    }

    public Node<E> root() {
        return (Node<E>) tree.root();
    }

    // pre-order traversal
    public void preorderPrint(Node<E> p) {
        if (p == null) return;
        if (valueOfNode(p) != null) System.out.print(valueOfNode(p) + " ");
        if (valueOfNode(left(p)) != null) preorderPrint(left(p));
        if (valueOfNode(right(p)) != null) preorderPrint(right(p));
    }

    // post-order traversal
    public void postorderPrint(Node<E> p) {
        if (p == null) return;
        if (valueOfNode(left(p)) != null) postorderPrint(p.getLeft());
        if (valueOfNode(right(p)) != null) postorderPrint(p.getRight());
        if (valueOfNode(p) != null) System.out.print(p.getElement() + " ");
    }

    // in-order traversal
    public void inorderPrint(Node<E> p) {
        if (p == null) return;
        if (numChildren(p) == 2) System.out.print("(");
        if (valueOfNode(left(p)) != null) inorderPrint(p.getLeft());
        if (valueOfNode(p) != null) System.out.print(p.getElement() + " ");
        if (valueOfNode(right(p)) != null) inorderPrint(p.getRight());
        if (numChildren(p) == 2) System.out.print(")");
    }

    // ex02-task_c
    // Evaluate expression from input expression tree
    public Double evaluateExpressionTree(Node<String> root) {
        if (root == null) return 0.0;

        if (root.getLeft() == null && root.getRight() == null) {
            return Double.parseDouble(root.getElement());
        }

        double resLeft = evaluateExpressionTree(root.getLeft());
        double resRight = evaluateExpressionTree(root.getRight());

        if (root.getElement().equals("+")) {
            return (resLeft + resRight);
        }
        if (root.getElement().equals("-")) {
            return (resLeft - resRight);
        }
        if (root.getElement().equals("*")) {
            return (resLeft * resRight);
        }
        return (resLeft / resRight);
    }
}
