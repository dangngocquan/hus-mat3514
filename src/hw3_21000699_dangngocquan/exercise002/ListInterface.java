package hw3_21000699_dangngocquan.exercise002;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public T set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
}
