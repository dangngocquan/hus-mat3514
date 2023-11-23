package hw6_21000673_nguyenvandai.exercise2;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> {
    protected static final int DEFAULT_CAPACITY = 10;
    protected ArrEntry<K, E>[] sortedPQ;
    protected int size;

    public SortedArrayPriorityQueue() {
        sortedPQ = new ArrEntry[DEFAULT_CAPACITY];
        size = 0;
    }
}
