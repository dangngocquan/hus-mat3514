package hw5_21000699_dangngocquan.base;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E, LinkedBinaryTree.LinkedBinaryTreeNode<E>> {
    public static class LinkedBinaryTreeNode<E> {
        E element;
        LinkedBinaryTreeNode<E> parent;
        LinkedBinaryTreeNode<E> left;
        LinkedBinaryTreeNode<E> right;

        public LinkedBinaryTreeNode(
                E element,
                LinkedBinaryTreeNode<E> parent,
                LinkedBinaryTreeNode<E> left,
                LinkedBinaryTreeNode<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private LinkedBinaryTreeNode<E> root;

    @Override
    public LinkedBinaryTreeNode<E> root() {
        return root;
    }

    @Override
    public E element(LinkedBinaryTreeNode<E> p) {
        return p.element;
    }

    @Override
    public LinkedBinaryTreeNode<E> parent(LinkedBinaryTreeNode<E> p) {
        if (p == null) return null;
        return p.parent;
    }

    @Override
    public LinkedBinaryTreeNode<E> left(LinkedBinaryTreeNode<E> p) {
        if (p == null) return null;
        return p.left;
    }

    @Override
    public LinkedBinaryTreeNode<E> right(LinkedBinaryTreeNode<E> p) {
        if (p == null) return null;
        return p.right;
    }

    @Override
    public LinkedBinaryTreeNode<E> sibling(LinkedBinaryTreeNode<E> p) {
        if (p == null) return null;
        if (p.parent == null) return null;
        return p.parent.left == p? p.parent.right : p.parent.left;
    }

    public LinkedBinaryTreeNode<E> addRoot(E element) {
        if (root == null) {
            root = new LinkedBinaryTreeNode<>(
                    element, null, null, null
            );
        }
        return root;
    }

    public LinkedBinaryTreeNode<E> addLeft(LinkedBinaryTreeNode<E> p, E element) {
        if (p == null) return null;
        if (p.left == null) {
            p.left = new LinkedBinaryTreeNode<>(
                    element, p, null, null
            );
        }
        return p.left;
    }

    public LinkedBinaryTreeNode<E> addRight(LinkedBinaryTreeNode<E> p, E element) {
        if (p == null) return null;
        if (p.right == null) {
            p.right = new LinkedBinaryTreeNode<>(
                    element, p, null, null
            );
        }
        return p.right;
    }

}
