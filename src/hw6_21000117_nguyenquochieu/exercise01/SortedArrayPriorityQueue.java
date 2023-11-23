package hw6_21000117_nguyenquochieu.exercise01;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected class ArrayEntry<K extends Comparable, E> implements Entry<K, E>, Comparable {
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

        @Override
        public int compareTo(Object o) {
            ArrayEntry entry = (ArrayEntry) o;
            return key.compareTo(entry.key);
        }
    }


    protected int n = 0;
    final int DEFAULT_SIZE = 1000;
    protected ArrayEntry<K, E>[] array = new ArrayEntry[DEFAULT_SIZE];
    public SortedArrayPriorityQueue() {
        array = new ArrayEntry[DEFAULT_SIZE];
    }

    public SortedArrayPriorityQueue(int n) {
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
        int index = 0;
        while (array[index].key.compareTo(entry.getKey()) < 0 && index < n) {
            index++;
        }
        n++;
        for (int i = n; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = (ArrayEntry<K, E>) entry;
    }

    @Override
    public void insert(Object o, Object o2) {
        ArrayEntry entry = new ArrayEntry<>((K) o, (E) o2);
        if (n >= array.length - 1) enlarge();
        if (n == 0) {
            array[0] = new ArrayEntry<>((K) o, (E) o2);
        } else {
            int index = 0;
            while (index < n && array[index].key.compareTo(entry.getKey()) < 0 ) {
                index++;
            }
            for (int i = n; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = entry;
        }
        n++;

    }

    @Override
    public Entry removeMin() {
        if (n == 0) return null;
        ArrayEntry minEntry = array[0];
        n--;
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        return minEntry;
    }

    @Override
    public Entry min() {
        if (n == 0) return null;
        return array[0];
    }
}
