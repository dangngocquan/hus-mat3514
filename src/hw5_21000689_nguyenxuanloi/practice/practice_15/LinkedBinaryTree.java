package hw5_21000689_nguyenxuanloi.practice.practice_15;

class Node<E> {
    private E element;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
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

public class LinkedBinaryTree<E> implements BinaryTreeInterface<Node<E>> {
    Node<E> root = null;
    int size = 0;

    @Override
    public Node<E> root() {
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
    public Node<E> sibling(Node<E> p) {
        if (p == root) {
            return null;
        } else {
            return (p.getParent().getLeft() == p) ? p.getParent().getRight() : p.getParent().getLeft();
        }
    }

    @Override
    public Node<E> right(Node<E> p) {
        return p.getRight();
    }

    @Override
    public Node<E> left(Node<E> p) {
        return p.getLeft();
    }

    @Override
    public Node<E> parent(Node<E> p) {
        return p.getParent();
    }

    @Override
    public int numChildren(Node<E> p) {
        return (p.getLeft() == null ? 0 : 1) + (p.getRight() == null ? 0 : 1);
    }

    public Node<E> addRoot(E element) {
        if (root != null && root.getElement() != null) {
            System.out.println("Root is already extant.");
            return null;
        } else {
            root = new Node<>(element, null, null, null);
            size++;
            return root;
        }
    }
    public Node<E> addLeft(Node<E> p, E element) {
        if (p.getLeft() != null) {
            System.out.println("Left node of given node is already extant.");
            return null;
        } else {
            Node<E> addedNode = new Node<>(element, p, null, null);
            p.setLeft(addedNode);
            size++;
            return addedNode;
        }
    }
    public Node<E> addRight(Node<E> p, E element) {
        if (p.getRight() != null) {
            System.out.println("Right node of given node is already extant.");
            return null;
        } else {
            Node<E> addedNode = new Node<>(element, p, null, null);
            p.setRight(addedNode);
            size++;
            return addedNode;
        }
    }

    public void set(Node<E> p, E element) {
        p.setElement(element);
    }
}
