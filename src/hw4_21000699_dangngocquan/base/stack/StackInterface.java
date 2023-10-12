package hw4_21000699_dangngocquan.base.stack;

public interface StackInterface<E> extends Iterable<E> {
    int size();
    void push(E element);
    E pop();
    boolean isEmpty();
    E top();
}