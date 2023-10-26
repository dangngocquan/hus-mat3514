package hw4_21000117_nguyenquochieu.exercise02;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
