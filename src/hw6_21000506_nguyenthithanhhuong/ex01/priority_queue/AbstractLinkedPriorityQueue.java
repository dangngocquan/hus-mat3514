package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public abstract class AbstractLinkedPriorityQueue<K extends Comparable<K>, E> extends AbstractPriorityQueue<K, E> {
     public static class NodeEntry<K, E> {
        public priEntry<K, E> entry;
        public NodeEntry<K, E> next;
        public NodeEntry(K k, E e) {
            entry = new priEntry<>(k, e);
            next = null;
        }
        public NodeEntry(Entry<K, E> newEntry) {
            entry = new priEntry<>(newEntry.getKey(), newEntry.getValue());
            next = null;
        }
    }
    public NodeEntry<K, E> head;
    public NodeEntry<K, E> tail;
    public int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        NodeEntry<K, E> node = head;
        while (node != null) {
            sb.append("(").append(node.entry.getKey())
              .append(",").append(node.entry.getValue())
              .append("), ");
            node = node.next;
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("}");
        return sb.toString();
    }
}
