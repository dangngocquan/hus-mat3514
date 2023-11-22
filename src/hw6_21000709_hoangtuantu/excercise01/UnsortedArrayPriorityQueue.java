package hw6_21000709_hoangtuantu.excercise01;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueue<K, E> {


    ArrEntry<K, E>[] array;
    int size = 0;
    final int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public UnsortedArrayPriorityQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        array = new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (size == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        array[size] = (ArrEntry<K, E>) entry;
        size++;
    }

    @Override
    public void insert(K k, E e) {
        if (size == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        ArrEntry<K, E> newEntry = new ArrEntry<>(k, e);
        array[size] = newEntry;
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        Entry<K, E> minEntry = array[minIndex];
        size--;
        array[minIndex] = array[size];
        array[size] = null;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i].getKey().compareTo(minEntry.getKey()) < 0) {
                minEntry = array[i];
            }
        }
        return minEntry;
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++){
            result.append("(").append(array[i]).append(")");
            if (i < size - 1){
                result.append(", ");
            }
        }return result.toString();
    }
}