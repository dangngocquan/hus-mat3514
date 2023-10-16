package hw5_21000699_dangngocquan.base;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E, LinkedBinaryTree.LinkedBinaryTreeNode<E>> {
    static class LinkedBinaryTreeNode<E> {
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
    }

    private LinkedBinaryTreeNode<E> root;
    private int size;

    @Override
    public LinkedBinaryTreeNode<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numberChildren(LinkedBinaryTreeNode<E> p) {
        if (p == null) return 0;
        int count = 0;
        if (p.left != null) count++;
        if (p.right != null) count++;
        return count;
    }

    @Override
    public LinkedBinaryTreeNode<E> parent(LinkedBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        return p.parent;
    }

    @Override
    public LinkedBinaryTreeNode<E> left(LinkedBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        return p.left;
    }

    @Override
    public LinkedBinaryTreeNode<E> right(LinkedBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        return p.right;
    }

    @Override
    public LinkedBinaryTreeNode<E> sibling(LinkedBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        if (p.parent == null) return null;
        return p.parent.left == p? p.parent.right : p.parent.left;
    }

    public LinkedBinaryTreeNode<E> addRoot(E element) {
        if (root == null) {
            root = new LinkedBinaryTreeNode<>(
                    element, null, null, null
            );
            size++;
        } else {
            System.out.println("Root already existed.");
        }
        return root;
    }

    public LinkedBinaryTreeNode<E> addLeft(LinkedBinaryTreeNode<E> p, E element) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        if (p.left == null) {
            p.left = new LinkedBinaryTreeNode<>(
                    element, p, null, null
            );
            size++;
        } else {
            System.out.println("The left node already existed.");
        }
        return p.left;
    }

    public LinkedBinaryTreeNode<E> addRight(LinkedBinaryTreeNode<E> p, E element) {
        if (p == null) {
            System.out.println("The current node is null.");
            return null;
        }
        if (p.right == null) {
            p.right = new LinkedBinaryTreeNode<>(
                    element, p, null, null
            );
            size++;
        } else {
            System.out.println("The right node already existed.");
        }
        return p.right;
    }

}
