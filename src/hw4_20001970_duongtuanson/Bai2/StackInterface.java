package hw4_20001970_duongtuanson.Bai2;

public interface StackInterface <E> extends Iterable<E> {
    public void push(E data);
    public E pop();
    public boolean isEmpty();
    public E top();
}
