package hw6_21000693_ledinhquangminh.Combo4Advanced;


public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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
    private NodeEntry<K, E> tail;
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
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
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

        NodeEntry<K, E> minNode = findMinNode();
        NodeEntry<K, E> prev = findPrev(minNode);

        if (prev == null) {
            // minNode is the head
            head = minNode.next;
        } else {
            prev.next = minNode.next;
        }

        if (minNode == tail) {
            // minNode is the tail
            tail = prev;
        }

        n--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return findMinNode();
    }

    // Helper method to find the node with the minimum key
    private NodeEntry<K, E> findMinNode() {
        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.key.compareTo(minNode.key) < 0) {
                minNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return minNode;
    }

    // Helper method to find the node before a given node
    private NodeEntry<K, E> findPrev(NodeEntry<K, E> target) {
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> currentNode = head;
        while (currentNode != null && currentNode != target) {
            prev = currentNode;
            currentNode = currentNode.next;
        }
        return prev;
    }
}

