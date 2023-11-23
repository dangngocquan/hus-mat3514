package hw6_21000685_dinhchinhkhang.Task1;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.PriorityQueueInterface;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E>
{
    protected static class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;
        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            next = null;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        public String toString() {
            return "(key: " + key + ", value: " + element + ")";
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    public SortedLinkedPriorityQueue() {
        head = null;
        tail = null;
    }
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
        if(isEmpty() || newNode.key.compareTo(head.key) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeEntry<K, E> current = head;
            while(current.next != null) {
                if(newNode.key.compareTo(current.next.key) < 0) {
                    newNode.next = current.next;
                    current.next = newNode;
                }
                current = current.next;
            }
            tail = current;
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
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        tail = current;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return head;
    }
}
