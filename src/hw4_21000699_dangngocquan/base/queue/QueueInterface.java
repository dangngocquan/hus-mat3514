package hw4_21000699_dangngocquan.base.queue;

public interface QueueInterface<E> extends Iterable<E> {
    int size();

    void enqueue(E element);

    E dequeue();

    E first();

    E last();

    boolean isEmpty();
}
