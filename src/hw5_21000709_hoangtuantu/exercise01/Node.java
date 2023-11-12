package hw5_21000709_hoangtuantu.exercise01;


public class Node<E> {
    public E element;
    public Node<E> parent;
    public Node<E> left;
    public Node<E> right;

    public Node(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        this.element = e;
        this.parent = parent;
        this.left = leftChild;
        this.right = rightChild;
    }

    public Node(E element) {
        this.element = element;
    }

    public Node(E element , Node<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return element + "";
    }
}
