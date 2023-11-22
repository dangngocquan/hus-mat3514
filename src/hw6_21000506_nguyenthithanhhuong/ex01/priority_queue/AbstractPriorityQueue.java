package hw6_21000506_nguyenthithanhhuong.ex01.priority_queue;

public abstract class AbstractPriorityQueue<K, E> implements PriorityQueueInterface<K, E> {
    public static class priEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;

        public priEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return "(" + key + "," + element + ")";
        }
    }
}
