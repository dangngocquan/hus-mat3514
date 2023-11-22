package hw6_22001273_nguyenhoangminh.exercise1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K key, E element) {
            this.key = key;
            this.element = element;
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
            return "(" + key.toString() + "," + element.toString() + ") ";
        }
    }

    private int size = 0;

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newest = (NodeEntry<K, E>) entry;
        newest.next = head;
        head = newest;

        size++;
        if (size == 1) { tail = head; }
    }

    @Override
    public void insert(K key, E value) {
        insert(new NodeEntry(key, value));
    }


    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        NodeEntry<K, E> current = head;
        K min = head.getKey();
        NodeEntry<K, E> minNode = head;

        while (current != null) {
            if (min.compareTo(current.getKey()) >= 0) {
                min = current.getKey();
                minNode = current;
            }
            current = current.next;
        }

        return minNode;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        if (size == 1) return head;

        NodeEntry<K, E> current = (NodeEntry<K, E>) min();
        if (current.equals(head)) {
            head = current.next;
            current.next = null;
            return current;
        }

        NodeEntry<K, E> beforeCurrent = head;
        while(!current.equals(beforeCurrent.next)) {
            beforeCurrent = beforeCurrent.next;
        }
        if (current.equals(tail)) {
            beforeCurrent.next = null;
        } else {
            beforeCurrent.next = current.next;
        }

        size--;

        return current;
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        NodeEntry<K, E> current = head;
        for (int i = 0; i < size - 1; i++) {
            if (current == null) {
                System.out.println("null");
            }
            queue.append(current.toString());
            current = current.next;
        }

        return queue.toString();
    }
}
