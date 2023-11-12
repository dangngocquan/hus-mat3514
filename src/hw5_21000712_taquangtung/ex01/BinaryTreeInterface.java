package hw5_21000712_taquangtung.ex01;

public interface BinaryTreeInterface<T> {
    T root();
    int size();     // Số node trong tree
    boolean isEmpty();
    int numChildren(T p);       // Số con của element p
    T parent(T p);          // trả về cha của p
    T left(T p);        // Con trái của p
    T right(T p);       // Con phải của p
    T sibling(T p);     // Anh chị em của p
}
