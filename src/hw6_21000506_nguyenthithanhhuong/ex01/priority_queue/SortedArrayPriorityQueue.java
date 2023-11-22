package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> extends AbstractArrayPriorityQueue<K, E> {
    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) return;
        priEntry<K, E> newEntry = new priEntry<>(entry.getKey(), entry.getValue());
        insertElement(newEntry);
    }

    @Override
    public void insert(K k, E e) {
        priEntry<K, E> newEntry = new priEntry<>(k, e);
        insertElement(newEntry);
    }

    private void insertElement(priEntry<K, E> entry) {
        if (isEmpty()) {
            array[n] = entry;
        }
        if (n == array.length) enlarge();
        int i = n;
        while (i > 0 && entry.getKey().compareTo(array[i-1].getKey()) < 0) {
            array[i--] = array[i];
        }
        array[i] = entry;
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return array[0];
    }
}
