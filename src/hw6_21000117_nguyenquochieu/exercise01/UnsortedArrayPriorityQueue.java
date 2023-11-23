package hw6_21000117_nguyenquochieu.exercise01;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected class ArrayEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrayEntry(K key, E element) {
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

    ArrayEntry<K, E>[] array;
    int n = 0;
    final int DEFAULT_SIZE = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrayEntry[DEFAULT_SIZE];
    }

    public UnsortedArrayPriorityQueue(int n) {
        this.n = n;
        this.array = new ArrayEntry[n];
    }

    private void enlarge() {
        ArrayEntry<K, E>[] newArr = new ArrayEntry[n + DEFAULT_SIZE];
        System.arraycopy(array, 0, newArr, 0, n);
        array = newArr;
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
    public void insert(Entry entry) {
        if (n >= array.length - 1) enlarge();
        array[n++] = (ArrayEntry<K, E>) entry;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (n >= array.length - 1) enlarge();
        ArrayEntry<K, E> entryValue = new ArrayEntry<>((K) o, (E) o2);
        array[n++] = (ArrayEntry<K, E>) entryValue;
    }

    @Override
    public Entry removeMin() {
        if (n == 0) return null;
        K minKey = array[0].key;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].key.compareTo(minKey) < 0) {
                index = i;
                minKey = array[i].key;
            }
        }
        ArrayEntry foundValue = array[index];
        n--;
        for (int i = index; i < n; i++) {
            array[i] = array[i + 1];
        }
        return foundValue;
    }

    @Override
    public Entry min() {
        if (n == 0) return null;
        K minKey = array[0].key;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].key.compareTo(minKey) < 0) {
                index = i;
                minKey = array[i].key;
            }
        }
        return array[index];
    }
}
