package hw6_21000709_hoangtuantu.excercise01;

public class NodeEntry<K, E> implements Entry<K, E> {
    private K key;
    private E element;
    private NodeEntry<K, E> next;

    public NodeEntry(K k, E e) {
        key = k;
        element = e;
        next = null;
    }

    public NodeEntry<K,E> getNext() {
        return next;
    }

    public void setNext(NodeEntry<K,E> next) {
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public E getValue() {
        return element;
    }

    @Override
    public String toString() {
        return key + ":" + element;
    }
}
