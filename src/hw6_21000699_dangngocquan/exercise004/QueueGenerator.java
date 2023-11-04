package hw6_21000699_dangngocquan.exercise004;

import hw6_21000699_dangngocquan.base.*;

import java.util.Random;

public class QueueGenerator {
    protected static class UnsortedArrayPriorityQueueGenerator
            extends UnsortedArrayPriorityQueue<Integer, Integer> {
        public PriorityQueueInterface<Integer, Integer> generateRandomQueue(int size) {
            Random random = new Random();
            data = new EntryInterface[size];
            for (int i = 0; i < size; i++) {
                int x = random.nextInt(1000);
                data[i] = new Entry<>(x, x);
            }
            this.size = size;
            return this;
        }
    }

    protected static class SortedArrayPriorityQueueGenerator
            extends SortedArrayPriorityQueue<Integer, Integer> {
        public PriorityQueueInterface<Integer, Integer> generateRandomQueue(int size) {
            data = new EntryInterface[size];
            for (int i = 0; i < size; i++) {
                data[i] = new Entry<>(i, i);
            }
            this.size = size;
            return this;
        }
    }

    protected static class UnsortedLinkedPriorityQueueGenerator
            extends UnsortedLinkedPriorityQueue<Integer, Integer> {
        public PriorityQueueInterface<Integer, Integer> generateRandomQueue(int size) {
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                Integer x = random.nextInt(1000);
                if (i == 0) {
                    first = last = new Node<>(x, x);
                } else {
                    last.next = new Node<>(x, x);
                    last = last.next;
                }
            }
            this.size = size;
            return this;
        }
    }

    protected static class SortedLinkedPriorityQueueGenerator
            extends SortedLinkedPriorityQueue<Integer, Integer> {
        public PriorityQueueInterface<Integer, Integer> generateRandomQueue(int size) {
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    first = last = new Node<>(i, i);
                } else {
                    last.next = new Node<>(i, i);
                    last = last.next;
                }
            }
            this.size = size;
            return this;
        }
    }

    public PriorityQueueInterface<Integer, Integer> generateRandomUnsortedArrayQueue(int size) {
        return new UnsortedArrayPriorityQueueGenerator().generateRandomQueue(size);
    }

    public PriorityQueueInterface<Integer, Integer> generateRandomSortedArrayQueue(int size) {
        return new SortedArrayPriorityQueueGenerator().generateRandomQueue(size);
    }

    public PriorityQueueInterface<Integer, Integer> generateRandomUnsortedLinkedQueue(int size) {
        return new UnsortedLinkedPriorityQueueGenerator().generateRandomQueue(size);
    }

    public PriorityQueueInterface<Integer, Integer> generateRandomSortedLinkedQueue(int size) {
        return new SortedLinkedPriorityQueueGenerator().generateRandomQueue(size);
    }
}
