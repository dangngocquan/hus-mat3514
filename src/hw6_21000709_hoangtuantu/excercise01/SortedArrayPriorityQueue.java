package hw6_21000709_hoangtuantu.excercise01;

public class SortedArrayPriorityQueue <K extends Comparable<K>, E> implements PriorityQueue<K, E> {
    protected ArrEntry<K, E>[] array;
    protected int size = 0;
    final int DEFAULT_SIZE = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[DEFAULT_SIZE];
    }
    public SortedArrayPriorityQueue(int capacity) {
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

    private int index(Entry<K, E> entry){
        for (int i = 0; i < size; i++){
            if (entry.getKey().compareTo(array[i].getKey()) < 0) {
                return i;
            }
        }
        return 0;
    }
    @Override
    public void insert(Entry<K,E> entry) {
        if (size == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        int index = index(entry);
        move(size, index);
        array[index] = (ArrEntry<K, E>) entry;
        size++;
    }

    @Override
    public void insert(K k , E e) {
        if (size == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        ArrEntry<K, E> entry = new ArrEntry<>(k, e);
        int index = index(entry);
        move(size, index);
        array[index] = entry;
        size++;
    }

    private void move(int start, int end){
        for (int j = start; j > end; j--){
            array[j] = array[j - 1];
        }
    }

    @Override
    public Entry<K,E> removeMin() {
        if (isEmpty()){
            throw new NullPointerException("No element in queue!");
        }
        Entry<K,E> min = array[0];
        for (int i = 0; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return min;
    }

    @Override
    public Entry<K,E> min() {
        return array[0];
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
