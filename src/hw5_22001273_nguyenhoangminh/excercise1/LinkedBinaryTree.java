package hw5_22001273_nguyenhoangminh.excercise1;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        private E element;
        private Node<E> parent = null, left = null, right = null;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
            left = right = null;
        }

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
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

    private int size = 0;
    private Node<E> root = null;

    public T root() {
        return (T) root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T parent(T p) {
        return (T) ((Node<E>) p).getParent();
    }

    public T left(T p) {
        return (T) ((Node<E>) p).getLeft();
    }

    public T right(T p) {
        return (T) ((Node<E>) p).getRight();
    }

    public int numOfChildren(T p) {
        int count = 0;
        if (((Node<E>) p).getLeft() != null) {
            count++;
        }
        if (((Node<E>) p).getRight() != null) {
            count++;
        }
        return count;
    }

    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.getParent();
        if (parent.getLeft().equals(node)) {
            return (T) parent.getRight();
        } else {
            return (T) parent.getLeft();
        }
    }

    public void addRoot(E element) {
        if (!isEmpty()) {
            System.out.println("Non-empty root!");
        }
        root = new Node<>(element, null);
        size++;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.getLeft() != null) {
            System.out.println("Left child is not empty!");
        }
        p.setLeft(new Node<>(element, p));
        size++;
        return p.getLeft();
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.getRight() != null) {
            System.out.println("Right child is not empty!");
        }
        p.setRight(new Node<>(element, p));
        size++;
        return p.getRight();
    }

    public void set(Node<E> p, E element) {
        p.setElement(element);
    }

    public void print(Node<E> root, int space) {
        final int COUNT = 5;
        if (root == null) return;

        space += COUNT;
        print(root.getRight(), space);

        System.out.println();

        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.getElement());

        print(root.getLeft(), space);
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getElement() + " ");
            inOrder(root.getRight());
        }
    }
}
