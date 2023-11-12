package hw5_20001970_duongtuanson.Bai1;
import java.util.*;
public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
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
    }

    protected Node<E> root;
    private int size = 0;

    public LinkedBinaryTree() {
        root = null;
    }
    @Override
    public T root() {
        if (isEmpty()) {
            return null;
        }
        return (T) root.element;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int numChildren(T p) {
        // return number of children of p
        Node<E> node = findNode(p);
        if(node == null) {
            return 0;
        }
        int count = 0;
        if(node.left != null) {
            count++;
        }
        if(node.right != null) {
            count++;
        }
        return count;
    }
    @Override
    public T parent(T p) {
        // return parent of p
        Node<E> node = findNode(p);
        if(node == null) {
            return null;
        }
        return (T) node.parent;

    }
    @Override
    public T left(T p) {
        Node<E> node = findNode(p);
        if(node == null) {
            return null;
        }
        return (T) node.left;
    }
    @Override
    public T right(T p) {
        Node<E> node = findNode(p);
        if(node == null) {
            return null;
        }
        return (T) node.right;
    }
    @Override
    public T sibling(T p) {
        // return sibling of p
        Node<E> node = findNode(p);
        if(node == null) {
            return null;
        }
        if(node.parent.left == node) {
            return (T) node.parent.right;
        }
        return (T) node.parent.left;
    }
    public Node<E> addRoot(E element){
        //add element to root of an empty tree
        if(root != null) {
            return null;
        }
        root = new Node<>(element, null, null, null);
        size++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element){
        //add element to left child node of p if empty
        if(p.left != null) {
            return null;
        }
        int count = 0;
        Node<E> node = root;
        while(node != null) {
            if(node == p) {
                count++;
                break;
            }
            node = node.left;
        }
        if(count == 0) {
            return null;
        }
        p.left = new Node<>(element, p, null, null);
        size++;
        return p.left;
    }

    public Node<E> addRight(Node<E> p, E element){
        //add element to right child node of p if empty
        if(p.right != null) {
            return null;
        }
        p.right = new Node<>(element, p, null, null);
        size++;
        return p.right;
    }

    public void set(Node<E> p, E element){
        //set element to node p
        p.element = element;
    }
    public Node<E> findNode(T p) {
        if(p == null) {
            return null;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node<E> node = queue.remove();
            if(node.element == p) {
                return node;
            }
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
    }
    public Node<E> getHeight() {
        if(root == null) {
            return null;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        Node<E> node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }
    public void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
    public void printTreeHorizontal(){
        if(root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int height = getHeight().element.toString().length();
        int space = (int) Math.pow(2, getHeight().element.toString().length() + 1);
        int count = 0;
        while(!queue.isEmpty()) {
            Node<E> node = queue.remove();
            printSpace(space);
            System.out.print(node.element);
            printSpace(space);
            count++;
            if(count == Math.pow(2, height)) {
                System.out.println();
                height--;
                space = (int) Math.pow(2, height + 1);
                count = 0;
            }
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
