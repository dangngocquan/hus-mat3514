package hw6_21000693_ledinhquangminh.Combo4Advanced;


public interface PriorityQueueInterface<K, E> {
    int size();

    boolean isEmpty();

    void insert(Entry<K, E> entry);

    void insert(K key, E element);

    Entry<K, E> removeMin();

    Entry<K, E> min();
}