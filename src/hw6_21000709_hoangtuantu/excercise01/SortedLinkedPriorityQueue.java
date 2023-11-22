package hw6_21000709_hoangtuantu.excercise01;


public class SortedLinkedPriorityQueue <K extends Comparable , E > implements PriorityQueue<K, E>{
    private NodeEntry <K ,E > head ;
    private NodeEntry <K ,E > tail ;
    int size = 0;
    @Override
    public int size() {
        return size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K,E> entry) {
        NodeEntry<K, E> newNode = (NodeEntry<K, E>) entry;
        if (head == null || newNode.getKey().compareTo(head.getKey()) < 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (newNode.getKey().compareTo(tail.getKey()) >= 0) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            NodeEntry<K, E>  current = head;
            while (newNode.getKey().compareTo(current.getNext().getKey()) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insert(K k , E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (head == null || newNode.getKey().compareTo(head.getKey()) < 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (newNode.getKey().compareTo(tail.getKey()) >= 0) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            NodeEntry<K, E>  current = head;
            while (newNode.getKey().compareTo(current.getNext().getKey()) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public Entry<K,E> removeMin() {
        NodeEntry<K, E> min = head;
        head = head.getNext();
        size--;
        return min;
    }

    @Override
    public Entry<K,E> min() {
        return head;
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
