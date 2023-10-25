package hw5_21000699_dangngocquan.exercise004.models;

import java.util.ArrayList;

public class LinkedGeneralTree<E> implements GeneralTreeInterface<LinkedGeneralTree.Node<E>> {
    public static class Node<E> {
        E element;
        Node<E> parent;
        ArrayList<Node<E>> children;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
            this.children = new ArrayList<>();
        }

        public void addChild(Node<E> child) {
            children.add(child);
        }
    }

    Node<E> root;

    public LinkedGeneralTree() {

    }

    public E getElementOfNode(Node<E> node) {
        if (node == null) return null;
        return node.element;
    }

    public int width(Node<E> p) {
        if (p == null) return 0;
        int n = 0;
        for (Node<E> node : p.children) n += width(node);
        if (n == 0) n = 1;
        return n;
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public int size(Node<E> p) {
        if (p == null) return 0;
        int n = 1;
        for (Node<E> node: p.children) n += size(node);
        return n;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Node<E> parent(Node<E> p) {
        if (p == null) return null;
        return p.parent;
    }

    public ArrayList<Node<E>> children(Node<E> p) {
        if (p == null) return null;
        return p.children;
    }

    public Node<E> addRoot(E element) {
        if (root == null) root = new Node<>(element, null);
        return root;
    }

    public Node<E> addChild(Node<E> p, E elementChild) {
        Node<E> child = new Node<>(elementChild, p);
        p.addChild(child);
        return child;
    }

    public void removeChild(Node<E> p, Node<E> child) {
        if (p == null || child == null) return;
        for (int i = 0; i < p.children.size(); i++) {
            if (p.children.get(i) == child) {
                p.children.remove(i);
                break;
            }
        }
    }

    // p is a node in the tree
    public void modifyRoot(Node<E> p) {
        if (p == null) return;
        Node<E> parent = p.parent;
        if (parent == null) return;
        if (parent == root) {
            p.parent = null;
            removeChild(parent, p);
            p.children.add(parent);
            parent.parent = p;
            root = p;
        } else {
            modifyRoot(parent);
            modifyRoot(p);
        }
    }
}
