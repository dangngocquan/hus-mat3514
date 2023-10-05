package hw4_21000699_dangngocquan.exercise001;

public interface MyStack<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
