package hw4_21000689_nguyenxuanloi.exercises.ex4;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
