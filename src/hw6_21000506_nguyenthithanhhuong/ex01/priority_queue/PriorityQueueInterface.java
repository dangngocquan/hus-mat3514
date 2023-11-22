package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public interface PriorityQueueInterface<K, E> {
    int size();
    boolean isEmpty();
    void insert(Entry<K, E> entry);
    void insert(K k, E e);
    Entry<K, E> removeMin();
    Entry<K, E> min();
}
