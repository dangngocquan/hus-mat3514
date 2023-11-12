package hw5_21000117_nguyenquochieu.exercise02;

public class LinkedBinaryTree<E> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element,Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
    private Node<E> root;
    private int size = 0;
    public Node<E> getRoot() {
        return root;
    }
    public Node<E> addRoot(E element) {
        if (root == null) size++;
        root = new Node<>(element, null,null, null);
        return root;
    }
    public Node<E> addLeft(Node p, E element) throws NullPointerException {
        if (p.left == null) size++;
        Node node = new Node<>(element, null, null, null);
        p.left = node;
        return node;
    }
    public Node<E> addRight(Node p, E element) throws NullPointerException {
        if (p.right == null) size++;
        Node node = new Node<>(element, null, null, null);
        p.right = node;
        return node;
    }
    public void set(Node p, E element) throws NullPointerException {
        p.setElement(element);
    }
}
