package hw7_21000699_dangngocquan.base.list;

public class UnsortedLinkedList<E extends Comparable<E>> extends AbstractLinkedList<E> {
    @Override
    public boolean add(E value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            last = newNode;
            size++;
            return true;
        }
        last.next = newNode;
        last = last.next;
        size++;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
        Node newNode = new Node(value);
        if (index == size) {
            add(value);
            return;
        }
        if (index == 0) {
            newNode.next = first;
            first = newNode;
            size++;
            return;
        }
        Node prevNode = getNode(index - 1);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    @Override
    public E set(int index, E value) {
        Node node = getNode(index);
        E prevData = node.data;
        node.data = value;
        return prevData;
    }
}
