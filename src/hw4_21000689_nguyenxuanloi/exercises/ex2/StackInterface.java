package hw4_21000689_nguyenxuanloi.exercises.ex2;

public interface StackInterface<E> extends Iterable<E> {
    void push(E element);
    E pop();
    boolean isEmpty();
    E top();
    int size();
}
