package hw6_21000693_ledinhquangminh.Combo4Advanced;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newNode = (NodeEntry<K, E>) entry;

        if (isEmpty() || newNode.key.compareTo(head.key) < 0) {
            // Insert at the beginning if the list is empty or newNode should be the new head
            newNode.next = head;
            head = newNode;
        } else {
            // Find the appropriate position to insert the newNode
            NodeEntry<K, E> current = head;
            while (current.next != null && current.next.key.compareTo(newNode.key) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        NodeEntry<K, E> minNode = head;
        head = head.next;
        minNode.next = null;
        n--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return head;
    }
}
