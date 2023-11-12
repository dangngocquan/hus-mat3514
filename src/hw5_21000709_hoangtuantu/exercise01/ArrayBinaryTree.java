package hw5_21000709_hoangtuantu.exercise01;

import java.util.Random;

/**
 * An implementation of a binary tree using an array-based structure.
 *
 * @param <E> The type of elements that the tree holds.
 * @param <T> The type of elements that the binary tree nodes represent.
 */
public class ArrayBinaryTree<E, T> implements BinaryTree<T> {
    private final int DEFAULT_SIZE = 100;
    private final E[] array = initArray(DEFAULT_SIZE);
    private int size = 0;
    private E[] initArray(int size){
        return (E[]) new Object[size];
    }

    private int validate(T p){
        if (!(p instanceof Integer)){
            throw new IllegalArgumentException("Not valid position type");
        }return (int) p;
    }
    /**
     * Returns the root element of the binary tree.
     *
     * @return The root element of the tree.
     */
    @Override
    public T root() {
        return safeCast(0);
    }

    /**
     * Expands the underlying array when necessary.
     */
    private void expand() {
        E[] result = initArray(size * 5);
        System.arraycopy(array, 0, result, 0, size);
    }

    /**
     * Sets the root element of the binary tree.
     *
     * @param element The element to be set as the root.
     */
    public void setRoot(E element) {
        if (array[0] != null) {
            throw new ArrayStoreException("Already have root");
        }
        array[0] = element;
        size = 1;
    }

    /**
     * Sets the left child of a node in the binary tree.
     * If index of new node is more than container length, it expands size of container
     *
     * @param p       The index of the parent node.
     * @param element The element to be set as the left child.
     */
    public void setLeft(int p, E element) {
        if (p * 2 + 1 >= array.length - 5) {
            expand();
        }
        array[p * 2 + 1] = element;
        if (size < p * 2 + 2 + 1) {
            size = p * 2 + 2 + 1;
        }
    }

    /**
     * Sets the right child of a node in the binary tree.
     * If index of new node is more than container length, it expands size of container
     * @param p       The index of the parent node.
     * @param element The element to be set as the right child.
     */
    public void setRight(int p, E element) {
        if (p * 2 + 1 >= array.length - 5) {
            expand();
        }
        array[p * 2 + 2] = element;
        if (size < p * 2 + 2 + 1) {
            size = p * 2 + 2 + 1;
        }
    }

    /**
     * Returns the number of nodes in the binary tree.
     *
     * @return The number of nodes in the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the binary tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of children of a given node in the binary tree.
     *
     * @param p The node for which to determine the number of children.
     * @return The number of children for the given node.
     */
    @Override
    public int numChildren(T p) {
        int index = validate(p);
        if (index > size) {
            throw new ArrayStoreException("No element " + p + " in the tree");
        } else if (index * 2 + 1 > size) {
            return 0;
        } else if (array[index * 2 + 1] == null && array[index * 2 + 2] == null) {
            return 0;
        } else if (array[index * 2 + 1] == null ^ array[index * 2 + 2] == null) {
            return 1;
        }
        return 2;
    }

    private T safeCast(int index){
        return (T)(Object) index;
    }

    /**
     * Returns the parent node of a given node in the binary tree.
     *
     * @param p The node for which to find the parent.
     * @return The parent node of the given node.
     */
    @Override
    public T parent(T p) {
        int index = (int) p;
        if (index > size) {
            throw new IndexOutOfBoundsException("Don't have an element at index " + index);
        }
        if (index % 2 == 0) {
            return safeCast((index - 2) / 2);
        }
        return safeCast(((index - 1) / 2));
    }

    /**
     * Returns the left child of a given node in the binary tree.
     *
     * @param p The node for which to find the left child.
     * @return The left child of the given node.
     */
    @Override
    public T left(T p) {
        int index = (int) p;
        if (index > size) {
            throw new IndexOutOfBoundsException("Don't have an element at index " + index);
        } else if (index * 2 + 1 > size) {
            return null;
        }
        return safeCast(index * 2 + 1);
    }

    /**
     * Returns the right child of a given node in the binary tree.
     *
     * @param p The node for which to find the right child.
     * @return The right child of the given node.
     */
    @Override
    public T right(T p) {
        int index = (int) p;
        if (index > size) {
            throw new IndexOutOfBoundsException("Don't have an element at index " + index);
        } else if (index * 2 + 2 > size) {
            return null;
        }
        return safeCast(index * 2 + 2);
    }

    /**
     * Returns the sibling node of a given node in the binary tree.
     *
     * @param p The node for which to find the sibling.
     * @return The sibling node of the given node.
     */
    @Override
    public T sibling(T p) {
        int index = (int) p;
        if (index == 0) {
            throw new ArithmeticException("Root doesn't have a sibling!");
        } else if (index % 2 == 0) {
            return safeCast(index - 1);
        }
        return safeCast(index + 1);
    }

    /**
     * Performs a pre-order traversal of the binary tree starting from the given node.
     *
     * @param p The node from which to start the pre-order traversal.
     */
    public void printPreOrder(T p) {
        if (p != null){
            int index = (int) p;
            if (index >= 0 && index < size){
                if (array[index] != null){
                    System.out.print(array[index] + " ");
                }
                printPreOrder(left(p));
                printPreOrder(right(p));
            }
        }
    }

    /**
     * Performs an in-order traversal of the binary tree starting from the given node.
     *
     * @param p The node from which to start the in-order traversal.
     */
    public void printInOrder(T p) {
        if (p != null) {
            int index = (int) p;
            if (index >= 0 && index < size){
                printInOrder(left(p));
                if (null != array[index]){
                    System.out.print(array[index] + " ");
                }
                printInOrder(right(p));
            }
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
            int index = (int) p;
            if (index >= 0 && index < size){
                if (array[index] != null) {
                    System.out.print(array[index] + " ");
                }
            }
        }
    }

    /**
     * Returns a string representation of the binary tree.
     *
     * @return A string containing the elements of the tree in order.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }

    /**
     * Creates an array binary tree with random values for its nodes.
     *
     * @param size The size of the tree, determining the maximum number of child nodes in the tree.
     * @return An array binary tree with random values assigned to each node.
     */
    public static ArrayBinaryTree<Integer, Integer> randomIntegerTree(int size) {
        Random random = new Random();
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        final int BOUND = (int) Math.pow(10, 6);
        tree.setRoot(random.nextInt(BOUND));

        // Set random values for the child nodes of the tree.
        for (int i = 0; i < size; i++) {
            tree.setLeft(i, random.nextInt(BOUND));
            tree.setRight(i, random.nextInt(BOUND));
        }

        return tree;
    }
}