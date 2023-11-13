package hw7_21000699_dangngocquan.base.list;

public class SortedArrayList<E extends Comparable<E>> extends AbstractArrayList<E> {
    @Override
    public boolean add(E value) {
        if (size == data.length) enlarge();
        int i = size;
        while (i > 0 && value.compareTo(data[i-1]) < 0) data[i] = data[--i];
        data[i] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
        add(value);
    }

    @Override
    public E set(int index, E value) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        E prev = remove(index);
        add(value);
        return prev;
    }

    @Override
    public int indexOf(E value) {
        return indexOf(value, 0, size - 1);
    }

    private int indexOf(E value, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r ) / 2;
        int compare = value.compareTo(data[mid]);
        if (compare == 0) return mid;
        return compare < 0? indexOf(value, l, mid - 1) : indexOf(value, mid + 1, r);
    }
}
