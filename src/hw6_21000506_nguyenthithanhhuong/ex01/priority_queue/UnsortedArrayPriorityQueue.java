package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> extends AbstractArrayPriorityQueue<K, E> {
    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) return;
        if (n == array.length) enlarge();
        array[n] = new priEntry<>(entry.getKey(), entry.getValue());
        n++;
    }

    @Override
    public void insert(K k, E e) {
        if (n == array.length) enlarge();
        array[n] = new priEntry<>(k, e);
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = min();
        int minIdx = n;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(min)) {
                minIdx = i;
                break;
            }
        }
        for (int i = minIdx; i < n; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                minIdx = i;
            }
        }
        return array[minIdx];
    }
}
