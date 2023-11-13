package hw7_21000699_dangngocquan.base.list;

public class SortedLinkedList<E extends Comparable<E>> extends AbstractLinkedList<E> {
    private E value;

    @Override
    public boolean add(E value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            last = newNode;
            size++;
            return true;
        }
        if (value.compareTo(first.data) < 0) {
            newNode.next = first;
            first = newNode;
            size++;
            return true;
        }
        Node currentNode = first;
        while (currentNode.next != null) {
            if (value.compareTo(currentNode.next.data) < 0) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                size++;
                break;
            } else {
                currentNode = currentNode.next;
            }
        }
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
        E prevData = remove(index);
        add(value);
        return prevData;
    }
}
