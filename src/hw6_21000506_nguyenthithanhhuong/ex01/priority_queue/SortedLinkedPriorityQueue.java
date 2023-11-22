package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> extends AbstractLinkedPriorityQueue<K, E> {
    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) return;
        NodeEntry<K, E> node = new NodeEntry<>(entry.getKey(), entry.getValue());
        insertNode(node);
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> node = new NodeEntry<>(k, e);
        insertNode(node);
    }

    private void insertNode(NodeEntry<K, E> node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            n++;
            return;
        }
        if (node.entry.getKey().compareTo(head.entry.getKey()) < 0) {
            node.next = head;
            head = node;
            n++;
            return;
        }
        NodeEntry<K, E> currentNode = head;
        while (currentNode.next != null && node.entry.getKey().compareTo(currentNode.next.entry.getKey()) > 0) {
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;
        if (node.next == null) {
            tail = node;
        }
        n++;
    }
    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = min();
        if (n == 1) {
            head = null;
            tail = null;
            n--;
            return min;
        }
        head = head.next;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return new priEntry<>(head.entry.getKey(), head.entry.getValue());
    }
}
