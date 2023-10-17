package hw3_20000550_duongduyhieu.Bai2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;          // Mảng chứa các phần tử
    private int n = 0;          // Số phần tử hiện tại
    private int defaultSize = 100;  // Kích thước mặc định của mảng

    // Hàm tạo mặc định
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    // Hàm tạo với kích thước tùy chỉnh
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    // Thêm một phần tử vào danh sách
    public void add(T data) {
        if (n == array.length) {
            // Mảng đầy, cần mở rộng
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }
        array[n++] = data;
    }

    // Lấy phần tử tại vị trí i
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return array[i];
    }

    // Đặt giá trị của phần tử tại vị trí i
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        array[i] = data;
    }

    // Xoá một phần tử khỏi danh sách
    public void remove(T data) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            array[n - 1] = null;  // Gán phần tử cuối cùng là null
            n--;                 // Giảm số lượng phần tử đi 1
        }
    }

    // Kiểm tra xem một phần tử có tồn tại trong danh sách không
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    // Lấy kích thước của danh sách
    public int size() {
        return n;
    }

    // Kiểm tra xem danh sách có trống không
    public boolean isEmpty() {
        return n == 0;
    }

    // Triển khai giao diện Iterable để có thể lặp qua danh sách
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < n;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
