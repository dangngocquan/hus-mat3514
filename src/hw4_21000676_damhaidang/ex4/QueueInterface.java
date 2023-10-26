package hw4_21000676_damhaidang.ex4;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);

    public E dequeue();

    public boolean isEmpty();
}
