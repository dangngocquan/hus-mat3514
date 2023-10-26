package hw4_21000117_nguyenquochieu.exercise04;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
