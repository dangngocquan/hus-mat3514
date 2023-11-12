package hw5_21000689_nguyenxuanloi.practice.practice_21;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedBinaryTree<E> {
    private Node<E> root;
    int size;

    public Node<E> root() {
        return root;
    }
    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int size() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void addRoot(E element) {
        if (root == null || root.getElement() == null) {
            root = new Node<>(element,null, null);
            size++;
        } else {
            System.out.println("Root is already extant.");
        }
    }
    public void addLeft(Node<E> p, E element) {
        if (p.getLeft() == null || p.getLeft().getElement() == null) {
            Node<E> leftChild = new Node<>(element,null, null);
            p.setLeft(leftChild);
            size++;
        } else {
            System.out.println("Left child is already extant.");
        }
    }
    public void addRight(Node<E> p, E element) {
        if (p.getRight() == null || p.getRight().getElement() == null) {
            Node<E> rightChild = new Node<>(element,null, null);
            p.setRight(rightChild);
            size++;
        } else {
            System.out.println("Left child is already extant.");
        }
    }
    public void set(Node<E> p, E element) {
        p.setElement(element);
    }

    public LinkedBinaryTree<E> createTreeFromArray(E... arr) {
        if (arr.length == 0) {
            return null;
        } else {
            this.setRoot(createRootFromArray(this.root,0, arr));
            this.setSize(arr.length);
            return this;
        }
    }
    public Node<E> createRootFromArray(Node<E> root, int idx, E... arr) {
        if (arr.length == 0) {
            return null;
        } else {
            if (idx < arr.length) {
                root = new Node<>(arr[idx], null, null);
                root.setLeft(createRootFromArray(root.getLeft(), 2 * idx + 1, arr));
                root.setRight(createRootFromArray(root.getRight(), 2 * idx + 2, arr));
            }
            return root;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Tree is empty.");
        } else {
            Queue<Node<E>> nodes = new ArrayDeque<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                if (nodes.peek().getLeft() != null) {
                    nodes.add(nodes.peek().getLeft());
                    System.out.println(nodes.peek().getElement() + " - " + nodes.peek().getLeft().getElement());
                }
                if (nodes.peek().getRight() != null) {
                    nodes.add(nodes.peek().getRight());
                    System.out.println(nodes.peek().getElement() + " - " + nodes.peek().getRight().getElement());
                }
                nodes.poll();
            }
        }
    }
}
