package hw4_21000699_dangngocquan.exercise003;

public interface StackInterface<E> extends Iterable<E> {
    public int size();
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}