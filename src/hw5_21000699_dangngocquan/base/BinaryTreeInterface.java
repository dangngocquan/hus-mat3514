package hw5_21000699_dangngocquan.base;

public interface BinaryTreeInterface<T> {
    T root();
    int size();
    int size(T p);
    boolean isEmpty();
    int numberChildren(T p);
    T parent(T p);
    T left(T p);
    T right(T p);
    T sibling(T p);
}
