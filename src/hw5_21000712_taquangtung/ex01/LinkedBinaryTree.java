package hw5_21000712_taquangtung.ex01;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        private E element;          // Phần tử lưu trữ this.node
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        // Constructor trong Node
        public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() {
            return element;
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

        public String toString() {
            return element.toString();
        }
    }

    private Node<E> root;
    private int size;

    // update methods
    public Node<E> addRoot(E element) {
        if (root == null) {
            root = new Node<>(element, null, null, null);
            size = 1;
            return root;
        }
        return null;
    }

    public Node<E> addLeft(Node p, E element) {
        Node<E> node = (Node<E>) p;
        if (node.left == null) {
            Node<E> left = new Node<>(element, node, null, null);
            node.left = left;
            size++;
            return left;
        }

        return null;
    }

    public Node<E> addRight(Node p, E element) {
        Node<E> node = (Node<E>) p;
        if (node.right == null) {
            Node<E> right = new Node<>(element, node, null, null);
            node.right = right;
            size++;
            return right;
        }

        return null;
    }


    // Node gốc
    @Override
    public T root() {
        return (T) root;
    }

    // Kích cỡ của Linked List
    @Override
    public int size() {
        return size;
    }

    // Kiểm tra phần tử có rỗng không
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Số lượng con của Node p
    @Override
    public int numChildren(T p) {
        Node<T> node = (Node<T>) p;
        int countChild = 0;
        if (node.left != null) {
            countChild++;
        }

        if (node.right != null) {
            countChild++;
        }

        return countChild;
    }

    // Trả về cha của p
    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;

        // Kiểm tra cha có rỗng không
        Node<E> parent = node.parent;
        if (node.parent == null) {
            return null;
        }

        if (parent.left == node) {
            return (T) parent.right;
        } else {
            return (T) parent.left;
        }
    }

    public void set(Node p, E element) {
        Node<E> node = (Node<E>) p;
        node.element = element;
    }

}
