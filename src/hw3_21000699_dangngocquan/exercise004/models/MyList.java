package hw3_21000699_dangngocquan.exercise004.models;

public interface MyList<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
    public int indexOf(T data);
}
