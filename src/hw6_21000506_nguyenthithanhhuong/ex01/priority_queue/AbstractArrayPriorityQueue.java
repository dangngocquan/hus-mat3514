package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

import java.util.Arrays;

public abstract class AbstractArrayPriorityQueue <K extends Comparable<K>, E> extends AbstractPriorityQueue<K, E> {
    protected priEntry<K, E>[] array;
    protected int n = 0;
    protected int DEFAULT_SIZE = 100;

    public AbstractArrayPriorityQueue() {
        array = new priEntry[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    protected void enlarge() {
        array = Arrays.copyOf(array, array.length*2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < n; i++) {
            sb.append("(").append(array[i].getKey())
                    .append(",").append(array[i].getValue())
                    .append(")").append(",").append(" ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("}");
        return sb.toString();
    }
}
