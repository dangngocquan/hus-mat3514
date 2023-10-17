package hw3_20000550_duongduyhieu.Bai2;

// Định nghĩa giao diện ListInterface với các phương thức cơ bản cho danh sách.
interface ListInterface<T> extends Iterable<T> {
    void add(T data);

    T get(int i);

    void set(int i, T data);

    void remove(T data);

    boolean isContain(T data);

    int size();

    boolean isEmpty();
}
