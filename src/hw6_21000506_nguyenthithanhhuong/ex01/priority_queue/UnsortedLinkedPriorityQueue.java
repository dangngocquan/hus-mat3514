package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> extends AbstractLinkedPriorityQueue<K, E> {
    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) return;
        NodeEntry<K, E> nodeEntry = new NodeEntry<>(entry.getKey(), entry.getValue());
        insertNode(nodeEntry);
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> nodeEntry = new NodeEntry<>(k, e);
        insertNode(nodeEntry);
    }

    private void insertNode(NodeEntry<K, E> node) {
        if (isEmpty()) {
            head = node;
            tail = head;
            n++;
            return;
        }
        tail.next = node;
        tail = tail.next;
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

        if (min.equals(head.entry)) {
            head = head.next;
            n--;
            return min;
        }

        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> prevNode = head;
        int idx = 0;

        while (minNode.entry != min) {
            minNode = minNode.next;
            idx++;
        }
        idx--;
        while (idx-- > 0) {
            prevNode = prevNode.next;
        }
        prevNode.next = minNode.next;
        n--;
        return min;
    }


    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        NodeEntry<K, E> node = head;
        NodeEntry <K, E> min = head;
        for (int i = 0; i < n; i++) {
            if (node.entry.getKey().compareTo(min.entry.getKey()) < 0) {
                min = node;
            }
            node = node.next;
        }
        return min.entry;
    }
}