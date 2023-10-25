package hw5_21000699_dangngocquan.exercise005.models;

public abstract class AbstractBinaryTree<E, T> implements BinaryTreeInterface<T> {
    // Get element of a node in tree
    public abstract E elementOfNode(T p);

    @Override
    public int size(T p) {
        if (elementOfNode(p) == null) return 0;
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

    public int height(T p) {
        if (elementOfNode(p) == null) return 0;
        return 1 + Math.max(height(left(p)), height(right(p)));
    }
}
