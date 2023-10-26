package hw4_21000506_nguyenthithanhhuong.ex02;

public interface StackInterface<E> extends Iterable<E> {
    int size();
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
