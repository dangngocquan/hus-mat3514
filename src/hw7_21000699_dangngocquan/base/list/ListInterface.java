package hw7_21000699_dangngocquan.base.list;

public interface ListInterface<E> extends Iterable<E> {
    int size();
    boolean add(E value);
    void add(int index, E value);
    E get(int index);
    E set(int index, E value);
    E remove(int index);
    boolean remove(E value);

    int indexOf(E value);
    boolean isEmpty();
}
