package hw5_22001273_nguyenhoangminh.excercise1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int size = 0;
    private int DEFAULT_CAPACITY = 100;
    private int root = 1;

    public ArrayBinaryTree() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayBinaryTree(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public T root() {
        return (T) Integer.valueOf(root);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public T parent(T p) {
        int position = (int) p;
        if (position % 2 == 1) {
            return (T) Integer.valueOf((position - 1) / 2);
        } else {
            return (T) Integer.valueOf(position / 2);
        }
    }

    public T left(T p) {
        int position = (int) p;
        return (T) Integer.valueOf(position * 2);
    }

    public T right(T p) {
        int position = (int) p;
        return (T) Integer.valueOf(position * 2 + 1);
    }

    public T sibling(T p) {
        T parent = parent(p);
        if (left(parent) == p) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    public int numOfChildren(T p) {
        int count = 0;
        if (array[(int) left(p)] != null) { count++; }
        if (array[(int) right(p)] != null) { count++; }
        return count;
    }

    public void setRoot(E element) {
        array[1] = element;
        size++;
    }

    public int setLeft(int p, E element) {
        array[2 * p] = element;
        size++;
        return 2 * p;
    }

    public int setRight(int p, E element) {
        array[2 * p + 1] = element;
        size++;
        return 2 * p + 1;
    }

    public void set(int p, E element) {
        array[p] = element;
    }

    public E getElement(int p) {
        return array[p];
    }

    public void print(int root, int space) {
        final int COUNT = 5;
        if (array[root] == null) return;

        space += COUNT;

        print((int) right((T) Integer.valueOf(root)), space);

        System.out.println();
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(array[root]);

        print((int) left((T) Integer.valueOf(root)), space);
    }
}
