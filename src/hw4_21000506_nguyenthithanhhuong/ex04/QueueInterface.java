package hw4_21000506_nguyenthithanhhuong.ex04;

public interface QueueInterface<E> extends Iterable<E> {
    public int size();
    public boolean isEmpty();
    public void enqueue(E element);
    public E first();
    public E dequeue();
}
