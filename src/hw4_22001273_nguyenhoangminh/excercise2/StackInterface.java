package hw4_22001273_nguyenhoangminh.excercise2;

public interface StackInterface<E> extends Iterable<E> {
    public void push (E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
