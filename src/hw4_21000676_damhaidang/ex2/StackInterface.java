package hw4_21000676_damhaidang.ex2;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);

    public E pop();

    public boolean isEmpty();

    public E top();


}
