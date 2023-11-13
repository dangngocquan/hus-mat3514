package hw7_21000699_dangngocquan.exercise002;

import hw7_21000699_dangngocquan.base.tree.LinkedBinaryTree;

public class BinarySearchTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {
    public E findMin() {
        return findMin(root());
    }

    private E findMin(Node<E> root) {
        while (root != null && root.left != null) root = root.left;
        return root == null? null : root.element;
    }

    public Node<E> search(E x) {
        if (x == null) return null;
        return search(x, root());
    }

    private Node<E> search(E x, Node<E> root) {
        if (root == null) return null;
        int compare = x.compareTo(root.element);
        if (compare == 0) return root;
        return compare < 0? search(x, root.left) : search(x, root.right);
    }

    public boolean insert(E x) {
        if (x == null) return false;
        if (root() == null) {
            addRoot(x);
            return true;
        }
        return insert(x, root());
    }

    private boolean insert(E x, Node<E> root) {
        int compare = x.compareTo(root.element);
        if (compare == 0) return false; // Duplicated value
        if (compare < 0) {
            if (root.left == null) {
                addLeft(root, x);
                return true;
            }
            return insert(x, root.left);
        }
        if (root.right == null) {
            addRight(root, x);
            return true;
        }
        return insert(x, root.right);

    }

    // Return root of tree after deleted x
    public Node<E> delete(E x) {
        if (x == null) return root();
        return delete(x, root());
    }

    private Node<E> delete(E x, Node<E> root) {
        if (root == null) return null;
        int compare = x.compareTo(root.element);
        // case 1: has no child
        if (root.left == null && root.right == null)
            return compare == 0? null : root;
        // case 2: only has child left
        if (root.left != null && root.right == null) {
            if (compare == 0) return root.left;
            root.left = delete(x, root.left);
            if (root.left != null) root.left.parent = root; // update parent for root.left
            return root;
        }
        // case 3: only has child right
        if (root.left == null) {
            if (compare == 0) return root.right;
            root.right = delete(x, root.right);
            if (root.right != null) root.right.parent = root; // update parent for root.right
            return root;
        }
        // case 4: has two children
        if (compare == 0) {
            root.element = findMin(root.right);
            root.right = delete(root.element, root.right);
        } else if (compare < 0) {
            root.left = delete(x, root.left);
            if (root.left != null) root.left.parent = root; // update parent for root.left
        } else {
            root.right = delete(x, root.right);
            if (root.right != null) root.right.parent = root; // update parent for root.right
        }
        return root;
    }
}
