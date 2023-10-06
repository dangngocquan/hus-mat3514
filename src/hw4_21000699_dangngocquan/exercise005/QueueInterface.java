package hw4_21000699_dangngocquan.exercise005;

public interface QueueInterface<E> extends Iterable<E> {
    public int size();

    public void enqueue(E element);

    public E dequeue();

    public E first();

    public E last();

    public boolean isEmpty();
}
