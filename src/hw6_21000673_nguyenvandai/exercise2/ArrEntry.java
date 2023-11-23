package hw6_21000673_nguyenvandai.exercise2;

public class ArrEntry<K, E> {
    private K key;
    private E element;

    public ArrEntry(K key, E element) {
        this.key = key;
        this.element = element;
    }

    public K getKey() {
        return key;
    }

    public E getElement() {
        return element;
    }
}
