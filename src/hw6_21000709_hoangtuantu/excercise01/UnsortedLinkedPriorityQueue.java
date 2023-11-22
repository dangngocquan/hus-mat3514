package hw6_21000709_hoangtuantu.excercise01;

public class UnsortedLinkedPriorityQueue <K extends Comparable , E > implements PriorityQueue<K, E> {
    private NodeEntry <K ,E > head ;
    private NodeEntry <K ,E > tail ;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(K k , E e) {
        NodeEntry<K, E> entry = new NodeEntry<>(k, e);
        if (head == null){
            head = entry;
        }else{
            tail.setNext(entry);
        }
        tail = entry;
        size++;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (head == null){
            head = (NodeEntry<K, E> ) entry;
        }else{
            tail.setNext((NodeEntry<K, E> ) entry);
        }
        tail = (NodeEntry<K, E> ) entry;
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        NodeEntry<K, E> min = (NodeEntry<K, E>) min();
        NodeEntry<K, E> node = head;
        while (node.getNext() != null && node.getNext() == min){
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        size--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> node = head;
        while (node != null){
            if (node.getKey().compareTo(min.getKey()) < 0){
                min = node;
            }
            node = node.getNext();
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        NodeEntry<K, E> node = head;
        while (node != null){
            result.append("(").append(node).append(")").append(", ");
            node = node.getNext();
        }
        return result.toString();
    }
}
