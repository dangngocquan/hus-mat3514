package hw5_21000712_taquangtung.ex01;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    // Khởi tạo Constructor mặc định
    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }


    // Update Method
    public void setRoot(E element) {
        array[0] = element;
        n++;
    }

    public void setLeft(int p, E element) {
        int leftIndex = 2 * p + 1;
        if (leftIndex < array.length) {
            array[leftIndex] = element;
            n++;
        }
    }

    public void setRight(int p, E element) {
        int rightIndex = 2 * p + 2;
        if (rightIndex < array.length) {
            array[rightIndex] = element;
            n++;
        }
    }

    // Gốc của cây
    @Override
    public T root() {
        if (n == 0) {
            return null;
        }
        return (T) array[0];
    }

    // Kích cỡ của cây
    @Override
    public int size() {
        return n;
    }

    // Kiểm tra xem cây có rỗng không
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    // Số lượng con của p
    @Override
    public int numChildren(T p) {
        int indexRoot = indexOfElement(p);
        if (indexRoot == -1) {
            return 0;
        }

        // Con trái và con phải
        int leftChildIndex = 2 * indexRoot;
        int rightChildIndex = 2 * indexRoot + 1;

        int countChild = 0;
        if (leftChildIndex < n && array[leftChildIndex] != null) {
            countChild++;
        }

        if (rightChildIndex < n && array[rightChildIndex] != null) {
            countChild++;
        }

        return countChild;

    }

    // Cha của p
    @Override
    public T parent(T p) {
        int indexElement = indexOfElement(p);
        if (indexElement == 0 || indexElement == 1) {
            return null;
        }
        int indexParent = (indexElement - 1) / 2;
        return (T) array[indexParent];

    }

    @Override
    public T left(T p) {
        int indexRoot = indexOfElement(p);
        if (indexRoot == -1 || indexRoot == 0) {
            return null;
        }

        int leftChildIndex = 2 * indexRoot + 1;
        if (leftChildIndex < n) {
            return (T) array[leftChildIndex];
        }
        return null;
    }

    @Override
    public T right(T p) {
        int indexRoot = indexOfElement(p);
        if (indexRoot == -1 || indexRoot == 0) {
            return null;
        }

        int rightChildIndex = 2 * indexRoot + 2;
        if (rightChildIndex < n) {
            return (T) array[rightChildIndex];
        }
        return null;
    }

    @Override
    public T sibling(T p) {
        int indexElement = indexOfElement(p);

        // Kiểm tra Tree có 1 phần tử hay không có phần tử
        if (indexElement == -1 || indexElement == 0) {
            return null;
        }

        // Tìm siblings của element đó
        if (indexElement % 2 == 0) {
            // Element đang là con trái --> siblings là con phải
            int siblingIndex = indexElement + 1;
            if (siblingIndex >= 0 && siblingIndex < n) {
                return (T) array[siblingIndex];
            }
        } else {
            // Element đang là con phải --> siblings là con trái
            int siblingIndex = indexElement - 1;
            if (siblingIndex >= 0 && siblingIndex < n) {
                return (T) array[siblingIndex];
            }
        }
        return null;
    }

    // Phương thức tìm chỉ số của phần tử trong mảng
    private int indexOfElement(T p) {
        for (int i = 0; i < n; i++) {
            if (array[i] != null && array[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }

    public E getElementOfNode(Integer p) {
        return array[p];
    }
}
