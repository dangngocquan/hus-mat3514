package hw1_21000245_nguyenthihaphuong.Exercise2;

public class GenericArray<T> {
    private final T[] arr;

    public GenericArray(int size) {
        arr = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        arr[index] = value;
    }

    public T get(int index) {
        return arr[index];
    }
}
