package hw5_20001970_duongtuanson.Bai2;

public class LinkedBinaryTree<E> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public Node<E> getLeft() {
            return left;
        }
        public Node<E> getRight() {
            return right;
        }
        public void setElement(E element) {
            this.element = element;
        }
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        public void setRight(Node<E> right) {
            this.right = right;
        }
        protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
            return new Node<E>(e, parent, left, right);
        }
        protected Node<E> root = null;
        private int size = 0;
    }
    public LinkedBinaryTree() {
    }
}
