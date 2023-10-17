package hw3_20001970_duongtuanson.Bai2;

public interface ListInterface <T> extends Iterable<T>{
    public void add(T data);
    public T get (int i);
    public void set (int i, T data);
    public void remove (int i);
    public void isContain (T data);
    public int size();
    public boolean isEmpty();
}
