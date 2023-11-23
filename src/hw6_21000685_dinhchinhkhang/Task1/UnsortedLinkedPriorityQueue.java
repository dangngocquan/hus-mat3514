package hw6_21000685_dinhchinhkhang.Task1;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.PriorityQueueInterface;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
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

    public UnsortedLinkedPriorityQueue() {
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
        if(isEmpty()) {
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
        if(isEmpty()) {
            return null;
        }
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> minKeyInQueue = head;
        NodeEntry<K, E> prevMinKey = null;
        NodeEntry<K, E> previous = null;

        while(current != null) {
            if (minKeyInQueue.key.compareTo(current.key) > 0) {
                minKeyInQueue = current;
                prevMinKey = previous;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if(prevMinKey != null) {
            prevMinKey.next = minKeyInQueue.next;
        } else {
            head = minKeyInQueue.next;
        }
        if(minKeyInQueue == tail) {
            tail = prevMinKey;
        }
        n--;
        return minKeyInQueue;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            return null;
        }
        NodeEntry<K, E> minKeyInQueue = head;
        NodeEntry<K, E> current = head;
        while (current != null) {
            if(minKeyInQueue.key.compareTo(current.key) > 0) {
                minKeyInQueue = current;
            }
            current = current.next;
        }
        return minKeyInQueue;
    }
}
