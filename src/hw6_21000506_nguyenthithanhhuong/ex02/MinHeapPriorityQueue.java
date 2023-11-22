package hw6_21000506_nguyenthithanhhuong.ex02;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.AbstractArrayPriorityQueue;
import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.Entry;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends AbstractArrayPriorityQueue<K, E> {
    protected int parent(int i) {
        return i/2;
    }

    protected int left(int i) {
        return 2*i;
    }

    protected int right(int i) {
        return 2*i + 1;
    }

    protected boolean hasLeft(int i) {
        return left(i) < n;
    }

    protected boolean hasRight(int i) {
        return right(i) < n;
    }

    protected void upHead() {
        if (n == 0) return;
        int i = n;
        while (i > 0) {
            int p = parent(i);
            if (i > 1 && array[i].getKey().compareTo(array[p].getKey()) < 0) {
                swap(i, p);
                i = p;
            } else break;
        }
    }

    protected void downHeap() {
        if (n == 0) return;
        int i = 1;
        while (i < n) {
            int leftChild = left(i);
            int smallChild = leftChild;
            if (hasRight(i)) {
                int rightChild = right(i);
                if (array[i].getKey().compareTo(array[leftChild].getKey()) < 0
                && array[i].getKey().compareTo(array[rightChild].getKey()) < 0) break;
                if (array[leftChild].getKey().compareTo(array[rightChild].getKey()) > 0) {
                    smallChild = rightChild;
                }
                swap(i, smallChild);
                i = smallChild;
            } else if (hasLeft(i) && !hasRight(i)) {
                if (array[i].getKey().compareTo(array[leftChild].getKey()) < 0) break;
                swap(i, leftChild);
                i = leftChild;
            } else break;
        }
    }

    protected void swap(int i, int j) {
        priEntry<K, E> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) return;
        if (n == array.length - 1) enlarge();
        array[++n] = new priEntry<>(entry.getKey(), entry.getValue());
        upHead();
    }

    @Override
    public void insert(K k, E e) {
        if (n == array.length - 1) enlarge();
        array[++n] = new priEntry<>(k, e);
        upHead();
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = min();
        swap(1, n);
        n--;
        downHeap();
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return array[1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 1; i <= n; i++) {
            sb.append("(").append(array[i].getKey())
                    .append(",").append(array[i].getValue())
                    .append(")").append(",").append(" ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("}");
        return sb.toString();
    }
}
