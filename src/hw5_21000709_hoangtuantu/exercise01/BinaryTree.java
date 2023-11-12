package hw5_21000709_hoangtuantu.exercise01;

/**
 * An interface representing a binary tree.
 *
 * @param <T> The type of elements that the binary tree nodes represent.
 */
public interface BinaryTree<T> {
    /**
     * Returns the root element of the binary tree.
     *
     * @return The root element of the tree.
     */
    T root();

    /**
     * Returns the number of nodes in the binary tree.
     *
     * @return The number of nodes in the tree.
     */
    int size();

    /**
     * Checks if the binary tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of children of a given node in the binary tree.
     *
     * @param p The node for which to determine the number of children.
     * @return The number of children for the given node.
     */
    int numChildren(T p);

    /**
     * Returns the parent node of a given node in the binary tree.
     *
     * @param p The node for which to find the parent.
     * @return The parent node of the given node.
     */
    T parent(T p);

    /**
     * Returns the left child of a given node in the binary tree.
     *
     * @param p The node for which to find the left child.
     * @return The left child of the given node.
     */
    T left(T p);

    /**
     * Returns the right child of a given node in the binary tree.
     *
     * @param p The node for which to find the right child.
     * @return The right child of the given node.
     */
    T right(T p);

    /**
     * Returns the sibling node of a given node in the binary tree.
     *
     * @param p The node for which to find the sibling.
     * @return The sibling node of the given node.
     */
    T sibling(T p);
}
