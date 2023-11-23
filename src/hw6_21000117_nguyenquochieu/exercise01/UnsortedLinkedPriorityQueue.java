package hw6_21000117_nguyenquochieu.exercise01;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
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

        public String toString() {
            return key.toString() + " - " + element.toString();
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
    public void insert(Entry entry) {
        if (head == null) head = new NodeEntry<>((K) entry.getKey(), (E) entry.getValue());
        else if (tail == null) {
            tail = new NodeEntry<>((K) entry.getKey(), (E) entry.getValue());
            head.next = tail;
        } else {
            NodeEntry node = new NodeEntry<>((K) entry.getKey(), (E) entry.getValue());
            tail.next = node;
            tail = tail.next;
        }
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (head == null) head = new NodeEntry<>((K) o, (E) o2);
        else if (tail == null) {
            tail = new NodeEntry<>((K) o, (E) o2);
            head.next = tail;
        } else {
            NodeEntry node = new NodeEntry<>((K) o, (E) o2);
            tail.next = node;
            tail = tail.next;
        }
        n++;
    }

    @Override
    public Entry removeMin() {
        if (n == 0) return null;
        K key = head.key;
        NodeEntry temp = head;
        NodeEntry minNode = null;
        NodeEntry previousMinNode = null;
        NodeEntry foundNode = null;
        while (temp.next != null) {
            previousMinNode = temp;
            if (key.compareTo(temp.next.key) > 0) {
                key = (K) temp.next.key;
                minNode = temp.next;
            }
            temp = temp.next;
        }
        if (minNode == null) {
            foundNode = head;
            head = head.next;
        } else {
            foundNode = minNode;
            previousMinNode.next = minNode.next;
        }
        n--;
        return foundNode;
    }

    @Override
    public Entry min() {
        if (n == 0) return null;
        K key = head.key;
        NodeEntry temp = head;
        NodeEntry minNode = null;
        while (temp != null) {
            if (key.compareTo(temp.key) > 0) {
                key = (K) temp.key;
                minNode = temp;
            }
            temp = temp.next;
        }
        if (minNode == null) {
            return head;
        } else {
            return minNode;
        }
    }
}
