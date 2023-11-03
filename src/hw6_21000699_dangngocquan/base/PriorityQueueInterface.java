package hw6_21000699_dangngocquan.base;

public interface PriorityQueueInterface<K, E> {
    int size();
    boolean isEmpty();
    void insert(EntryInterface<K, E> entry);
    void insert(K k, E e);
    EntryInterface<K, E> removeMin();
    EntryInterface<K, E> min();
}