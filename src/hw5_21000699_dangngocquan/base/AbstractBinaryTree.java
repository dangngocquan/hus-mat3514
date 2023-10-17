package hw5_21000699_dangngocquan.base;

public abstract class AbstractBinaryTree<E, T> implements BinaryTreeInterface<T> {
    // Get element of a node in tree
    public abstract E element(T p);

    @Override
    public int size(T p) {
        if (p == null || element(p) == null) return 0;
        return 1 + size(left(p)) + size(right(p));
    }

    @Override
    public int size() {
        return size(root());
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int numberChildren(T p) {
        if (p == null || element(p) == null) return 0;
        int count = 0;
        if (element(left(p)) != null) count++;
        if (element(right(p)) != null) count++;
        return count;
    }

    // Tree to string
    @Override
    public String toString() {
        if (root() == null || element(root()) == null) return "";
        StringBuilder sb = new StringBuilder();
        createStringRightRootLeft(sb, maxLengthStringNode(root()) + 2, root());
        if (sb.length() > 0) {
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString();
    }

    private int maxLengthStringNode(T node) {
        if (node == null || element(node) == null) return 1;
        return Math.max(
                element(node).toString().length(),
                Math.max(
                        maxLengthStringNode(left(node)),
                        maxLengthStringNode(right(node))
                )
        );
    }

    public void createStringRightRootLeft(StringBuilder sb, int lengthPerColumn, T p) {
        if (p != null && element(p) != null) {
            // Draw right node
            if (right(p) == null || element(right(p)) == null) {
                sb.append(
                        "\n".repeat(
                                (1 << (height(root()) - level(p))) - 1
                        )
                );
            } else {
                createStringRightRootLeft(sb, lengthPerColumn, right(p));
            }

            // Draw root node
            sb.append(" ".repeat(lengthPerColumn * (level(p) - 1)))
                    .append(element(p))
                    .append("\n");

            // Draw left node
            if (left(p) == null || element(left(p)) == null) {
                sb.append(
                        "\n".repeat(
                                (1 << (height(root()) - level(p))) - 1
                        )
                );
            } else {
                createStringRightRootLeft(sb, lengthPerColumn, left(p));
            }
        }
    }

    public int level(T p) {
        if (p == null || element(p) == null) return 0;
        if (p == root()) return 1;
        return 1 + level(parent(p));
    }

    public int height(T p) {
        if (p == null || element(p) == null) return 0;
        return 1 + Math.max(height(left(p)), height(right(p)));
    }
}
