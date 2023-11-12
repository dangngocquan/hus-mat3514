package hw7_21000699_dangngocquan.exercise001.list;

public class UnsortedArrayList<E extends Comparable<E>> extends AbstractArrayList<E> {

    public UnsortedArrayList() {
        super();
    }

    public UnsortedArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(E value) {
        if (size == data.length) enlarge();
        data[size++] = value;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == data.length) enlarge();
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public E set(int index, E value) {
        E prev = get(index);
        data[index] = value;
        return prev;
    }
}
