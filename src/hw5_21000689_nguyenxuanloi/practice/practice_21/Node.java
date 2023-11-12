package hw5_21000689_nguyenxuanloi.practice.practice_21;

class Node<E> {
    E element;
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    public Node(E element, Node<E> left, Node<E> right) {
        this.element = element;
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
        if (left != null) {
            this.left = left;
            left.setParent(this);
        }
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        if (right != null) {
            this.right = right;
            right.setParent(this);
        }
    }
}
