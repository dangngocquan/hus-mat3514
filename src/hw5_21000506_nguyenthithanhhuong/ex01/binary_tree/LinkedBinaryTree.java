package hw5_21000506_nguyenthithanhhuong.ex01.binary_tree;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<LinkedBinaryTree.Node<E>> {
    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node() {

        }

        public Node(E element, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
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

    protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(element, parent, left, right);
    }

    private Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {

    }

    // Add element to root of an empty tree
    public Node<E> addRoot(E element) {
        if (isEmpty()) {
            root = createNode(element, null, null, null);
        }
        size++;
        return root;
    }

    // Add element to left child node of p if empty
    public Node<E> addLeft(Node<E> p, E element) {
        if (p == null) return null;
        if (p.getLeft() == null) {
            p.setLeft(createNode(element, p, null, null));
        }
        size++;
        return p.getLeft();
    }

    // Add element to right child node of p if empty
    public Node<E> addRight(Node p, E element) {
        if (p == null) return null;
        if (p.getRight() == null) {
            p.setRight(createNode(element, p, null, null));
        }
        size++;
        return p.getRight();
    }

    public void set(Node p, E element) {
        p.setElement(element);
    }

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
    public int numChildren(Node<E> p) {
        int result = 0;
        if (p.getRight() != null) result++;
        if (p.getLeft() != null) result++;
        return result;
    }

    @Override
    public Node<E> parent(Node<E> p) {
        if (p == null) return null;
        return p.getParent();
    }

    @Override
    public Node<E> left(Node<E> p) {
        if (p == null) return null;
        return p.getLeft();
    }

    @Override
    public Node<E> right(Node<E> p) {
        if (p == null) return null;
        return p.getRight();
    }

    @Override
    public Node<E> sibling(Node<E> p) {
        if (p == null || p.getParent() == null) return null;
        if (p == p.getParent().getLeft()) {
            return p.getParent().getRight();
        } else {
            return p.getParent().getLeft();
        }
    }

    // Get value of a node
    public E valueOfNode(Node<E> p) {
        if (p == null) return null;
        return p.getElement();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        stringRightParentLeft(sb, maxLengthOfNode(root()), root());
        return sb.toString();
    }

    // Convert tree to string with format RightRootLeft
    public void stringRightParentLeft(StringBuilder sb, int width, Node<E> p) {
        if (valueOfNode(p) != null) {
            if (valueOfNode(right(p)) != null) {
                stringRightParentLeft(sb, width, right(p));
            }

            sb.append(" ".repeat(distanceFromRootToLevel(p)))
                    .append(p.getElement())
                    .append("\n");

            if (valueOfNode(left(p)) != null) {
                stringRightParentLeft(sb, width, left(p));
            }
        }
    }

    // Find the max characters of value at node
    public int maxLengthOfNode(Node<E> p) {
        if (valueOfNode(p) == null) return 1;
        return Math.max(
                p.getElement().toString().length(),
                Math.max(
                        maxLengthOfNode(right(p)),
                        maxLengthOfNode(left(p))
                )
        );
    }

    // Define the distance from root to a level
    public int distanceFromRootToLevel(Node<E> p) {
        return maxLengthOfNode(root())*(level(p)-1)*3;
    }

    // Find level
    public int level(Node<E> p) {
        if (valueOfNode(p) == null) return 0;
        if (p == root()) return 1;
        return 1 + level(parent(p));
    }
}
