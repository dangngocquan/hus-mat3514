package hw4_22001273_nguyenhoangminh.excercise4;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
    public int size();
    public E first();
}
