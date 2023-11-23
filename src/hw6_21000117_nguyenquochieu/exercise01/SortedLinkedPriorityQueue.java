package hw6_21000117_nguyenquochieu.exercise01;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
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
        K key = (K) entry.getKey();
        NodeEntry temp = head;
        NodeEntry minNode = null;
        NodeEntry previousMinNode = null;
        NodeEntry foundNode = null;
        while (temp.next != null && key.compareTo(temp.key) > 0) {
            temp = temp.next;
        }
        if (temp.next != null) {
            NodeEntry node = (NodeEntry) entry;
            NodeEntry currentNextNode = temp.next;
            temp.next = node;
            node.next = currentNextNode;
        } else {
            tail.next = (NodeEntry) entry;
        }
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        K key = (K) o;
        E element = (E) o2;
        if (head == null) head = new NodeEntry<>(key, element);
        else if (tail == null) {
            NodeEntry node = new NodeEntry<>(key, element);
            if (key.compareTo(head.key) < 0) {
                node.next = head;
                head = node;
                tail = head.next;
            } else {
                tail = new NodeEntry<>(key, element);
                head.next = tail;
            }
        } else {
            NodeEntry temp = head;
            NodeEntry previousMinNode = null;
            NodeEntry foundNode = null;
            while (temp.next != null && key.compareTo(temp.key) > 0) {
                previousMinNode = temp;
                temp = temp.next;
            }
            if (previousMinNode == null) {
                NodeEntry tempNode = head;
                head = new NodeEntry<>(key, element);
                head.next = tempNode;
            } else if (previousMinNode.next == null) {
                NodeEntry newTail = new NodeEntry<>(key, element);
                tail.next = newTail;
                tail = tail.next;
            } else {
                NodeEntry postNode = previousMinNode.next;
                NodeEntry newNode = new NodeEntry<>(key, element);
                previousMinNode.next = newNode;
                newNode.next = postNode;
            }
        }
        n++;
    }


    @Override
    public Entry removeMin() {
        if (n == 0) return null;
        NodeEntry minNode = head;
        head = head.next;
        n--;
        return minNode;
    }

    @Override
    public Entry min() {
        if (n == 0) return null;
        return head;
    }
}
