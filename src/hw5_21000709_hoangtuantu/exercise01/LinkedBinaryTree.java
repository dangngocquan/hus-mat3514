package hw5_21000709_hoangtuantu.exercise01;

import java.util.Random;

/**
 * An implementation of a binary tree using a linked structure.
 *
 * @param <E> The type of elements that the tree holds.
 * @param <T> The type of elements that the binary tree nodes represent.
 */
public class LinkedBinaryTree<E, T> implements BinaryTree<T> {
    private Node<E> root;

    private T validate(Node<E> p){
        return (T) p;
    }
    protected Node<E> safeCast(T p){
        if (!(p instanceof Node)){
            throw new IllegalArgumentException("Not valid position type");
        }
        return (Node<E>) p;

    }

    /**
     * Adds a root node to the binary tree with the given element.
     *
     * @param element The element to be added as the root.
     * @return The newly created root node.
     * @throws IllegalStateException if a root node already exists.
     */
    public Node<E> addRoot(E element) {
        if (root != null) {
            throw new IllegalStateException("Root already exists.");
        }
        root = new Node<>(element);
        return root;
    }

    /**
     * Adds a left child to a given node with the specified element.
     *
     * @param p       The parent node to which the left child will be added.
     * @param element The element to be added as the left child.
     * @return The newly created left child node.
     * @throws IllegalStateException if a left child already exists for the parent node.
     */
    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left != null) {
            throw new IllegalStateException("Left child already exists.");
        }
        Node<E> newNode = new Node<>(element, p);
        p.left = newNode;
        return newNode;
    }

    /**
     * Adds a right child to a given node with the specified element.
     *
     * @param p       The parent node to which the right child will be added.
     * @param element The element to be added as the right child.
     * @return The newly created right child node.
     * @throws IllegalStateException if a right child already exists for the parent node.
     */
    public Node<E> addRight(Node<E> p, E element) {
        if (p.right != null) {
            throw new IllegalStateException("Right child already exists.");
        }
        Node<E> newNode = new Node<>(element, p);
        p.right = newNode;
        return newNode;
    }

    /**
     * Sets the element of a given node.
     *
     * @param p       The node for which to set the element.
     * @param element The new element to be assigned to the node.
     */
    public void set(Node<E> p, E element) {
        p.element = element;
    }

    /**
     * Returns the root element of the binary tree.
     *
     * @return The root element of the tree.
     */
    @Override
    public T root() {
        return validate(root);
    }

    /**
     * Returns the number of nodes in the binary tree.
     *
     * @return The number of nodes in the tree.
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * Recursively calculates the size of a node and its descendants.
     *
     * @param node The root node for the size calculation.
     * @return The size of the node and its descendants.
     */
    private int size(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    /**
     * Checks if the binary tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of children of a given node in the binary tree.
     *
     * @param p The node for which to determine the number of children.
     * @return The number of children for the given node.
     */
    @Override
    public int numChildren(T p) {
        if (p == null) {
            throw new NullPointerException("No element in the tree");
        }
        Node<E> node = safeCast(p);
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left == null ^ node.right == null) {
            return 1;
        }
        return 2;
    }

    /**
     * Returns the parent node of a given node in the binary tree.
     *
     * @param p The node for which to find the parent.
     * @return The parent node of the given node.
     */
    @Override
    public T parent(T p) {
        if (p == null) {
            throw new NullPointerException("Can't find the parent element of null");
        }
        Node<E> node = safeCast(p);
        return validate(node.parent);
    }

    /**
     * Returns the left child of a given node in the binary tree.
     *
     * @param p The node for which to find the left child.
     * @return The left child of the given node.
     */
    @Override
    public T left(T p) {
        if (p == null) {
            throw new NullPointerException("Can't find the left element of null");
        }
        Node<E> node = safeCast(p);
        return validate(node.left);
    }

    /**
     * Returns the right child of a given node in the binary tree.
     *
     * @param p The node for which to find the right child.
     * @return The right child of the given node.
     */
    @Override
    public T right(T p) {
        if (p == null) {
            throw new NullPointerException("Can't find the right element of null");
        }
        Node<E> node = safeCast(p);
        return validate(node.right);
    }

    /**
     * Returns the sibling node of a given node in the binary tree.
     *
     * @param p The node for which to find the sibling.
     * @return The sibling node of the given node.
     */
    @Override
    public T sibling(T p) {
        if (p == null) {
            throw new NullPointerException("Can't find the sibling element of null");
        }

        Node<E> node = safeCast(p);
        Node<E> parent = node.parent;
        if (parent.left.equals(p)) {
            return validate(parent.right);
        }
        return validate(parent.left);
    }

    /**
     * Performs a pre-order traversal of the binary tree starting from the given node.
     *
     * @param p The node from which to start the pre-order traversal.
     */
    public void printPreOrder(T p) {
        if (p != null) {
            System.out.print((safeCast(p)).element + " ");
            printPreOrder(left(p));
            printPreOrder(right(p));
        }
    }

    /**
     * Performs an in-order traversal of the binary tree starting from the given node.
     *
     * @param p The node from which to start the in-order traversal.
     */
    public void printInOrder(T p) {
        if (p != null) {
            printInOrder(left(p));
            System.out.print((safeCast(p).element + " "));
            printInOrder(right(p));
        }
    }

    /**
     * Performs a post-order traversal of the binary tree starting from the given node.
     *
     * @param p The node from which to start the post-order traversal.
     */
    public void printPostOrder(T p) {
        if (p != null) {
            printPostOrder(left(p));
            printPostOrder(right(p));
            System.out.print(safeCast(p).element + " ");
        }
    }

    /**
     * Performs a level-order traversal of the binary tree.
     */
    public void printLevelOrder() {
        // Implementation needed
    }

    /**
     * Adds random elements to the binary tree.
     *
     * @param p     The node to which to add child elements.
     * @param size  The size of the subtree to generate.
     * @param bound The upper bound for random element values.
     */
    public void add(T p, int size, int bound) {
        if (size > 0) {
            addLeft((Node<E>) p, (E) (Object) new Random().nextInt(bound));
            add(left(p), size - 1, bound);
            addRight((Node<E>) p, (E) (Object) new Random().nextInt(bound));
            add(right(p), size - 1, bound);
        }
    }

    /**
     * Creates a linked binary tree with random values for its nodes.
     *
     * @param level The level of the tree, determining the maximum number of child nodes in the tree.
     * @return A linked binary tree with random values assigned to each node.
     */
    public static LinkedBinaryTree<Integer, Node<Integer>> randomIntegerTree(int level) {
        LinkedBinaryTree<Integer, Node<Integer>> tree = new LinkedBinaryTree<>();
        final int BOUND = (int) Math.pow(10, 6);
        Random random = new Random();
        tree.addRoot(random.nextInt(BOUND));
        tree.add(tree.root, level, BOUND);
        return tree;
    }
}