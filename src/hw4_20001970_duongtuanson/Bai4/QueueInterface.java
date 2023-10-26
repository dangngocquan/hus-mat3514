package hw4_20001970_duongtuanson.Bai4;

public interface QueueInterface <E> extends Iterable<E> {
    public void enqueue(E data);
    public E dequeue();
    public boolean isEmpty();
}
