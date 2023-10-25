package hw5_21000699_dangngocquan.exercise005.models;

public interface BinaryTreeInterface<T> {
    T root();
    int size();
    int size(T p);
    boolean isEmpty();
    T parent(T p);
    T left(T p);
    T right(T p);
}
