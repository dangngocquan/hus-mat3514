package hw5_21000117_nguyenquochieu.exercise02;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public void preorderPrint(Node<E> p) {
        if (p == null) return;
        System.out.print(p.getElement() + " ");
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) return;
        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (p == null) return;
        inorderPrint(p.getLeft());
        System.out.print(p.getElement() + " ");
        inorderPrint(p.getRight());
    }

    public static void printExpression(Node<Character> root) {
        if (root == null) return;
        if (root.getLeft() != null) {
            System.out.print("(");
            printExpression(root.getLeft());
        }
        System.out.print(root.getElement());
        if (root.getRight() != null) {
            printExpression(root.getRight());
            System.out.print(")");
        }
    }

    public static int evaluate(Node<Character> root) {
        if (root == null)
            return 0;
        if (root.getLeft() == null && root.getRight() == null) {
            int term = Character.getNumericValue(root.getElement());
            return term;
        }
        int leftEval = evaluate(root.getLeft());
        int rightEval = evaluate(root.getRight());

        if (root.getElement() == '+')
            return leftEval + rightEval;

        if (root.getElement() == '-')
            return leftEval - rightEval;

        if (root.getElement() == '*')
            return leftEval * rightEval;

        return leftEval / rightEval;
    }

    public static void testTraversal() {
        ExpressionTree<Character> tree = new ExpressionTree<>();
        addData(tree);
        System.out.println("Pre-order Traversal: ");
        tree.preorderPrint(tree.getRoot());
        System.out.println("\nIn-order Traversal: ");
        tree.inorderPrint(tree.getRoot());
        System.out.println("\nPost-order Traversal: ");
        tree.postorderPrint(tree.getRoot());
        System.out.println("\nExpression Evaluation: ");
        printExpression(tree.getRoot());
        System.out.print(" = ");
        System.out.println(evaluate(tree.getRoot()));
    }

    private static void addData(ExpressionTree tree) {
        LinkedBinaryTree.Node root = tree.addRoot('+');
        LinkedBinaryTree.Node leftNode1 = tree.addLeft(root, '*');
        LinkedBinaryTree.Node rightNode1 = tree.addRight(root, '-');
        LinkedBinaryTree.Node leftNode2 = tree.addLeft(leftNode1, '/');
        LinkedBinaryTree.Node rightNode2 = tree.addRight(leftNode1, '+');
        LinkedBinaryTree.Node leftNode3 = tree.addLeft(rightNode1, '-');
        LinkedBinaryTree.Node rightNode3 = tree.addRight(rightNode1, '*');
        LinkedBinaryTree.Node leftNode4 = tree.addLeft(leftNode2, '4');
        LinkedBinaryTree.Node rightNode4 = tree.addRight(leftNode2, '4');
        LinkedBinaryTree.Node leftNode5 = tree.addLeft(rightNode2, '7');
        LinkedBinaryTree.Node rightNode5 = tree.addRight(rightNode2, '4');
        LinkedBinaryTree.Node leftNode6 = tree.addLeft(leftNode3, '5');
        LinkedBinaryTree.Node rightNode6 = tree.addRight(leftNode3, '3');
        LinkedBinaryTree.Node leftNode7 = tree.addLeft(rightNode3, '2');
        LinkedBinaryTree.Node rightNode7 = tree.addRight(rightNode3, '1');
    }
}
