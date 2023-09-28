package hw3_21000699_dangngocquan.exercise010;

public class MyLinkedList<T> {
    private LinkedListNode<T> head;
    private int n;
    public MyLinkedList() {

    }

    public T get(int index) {
        LinkedListNode<T> node = getNode(index);
        if (node == null) return null;
        return node.value;
    }

    public LinkedListNode<T> getNode(int index) {
        if (index < 0 || index >= n) {
            return null;
        }
        LinkedListNode node = head;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    public void addAtHead(T val) {
        LinkedListNode<T> node = new LinkedListNode<>();
        node.value = val;
        node.next = head;
        head = node;
        n++;
    }

    public void addAtTail(T val) {
        LinkedListNode<T> node = new LinkedListNode<>();
        node.value = val;
        if (n == 0) {
            head = node;
        } else {
            getNode(n-1).next = node;
        }
        n++;
    }

    public void addAtIndex(int index, T val) {
        if (index < 0 || index > n) return;
        if (index == n) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        LinkedListNode<T> node = new LinkedListNode<>();
        node.value = val;
        node.next = getNode(index);
        getNode(index-1).next = node;
        n++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) return;
        if (index == 0) {
            head = getNode(1);
            n--;
            return;
        }
        if (index == n-1) {
            getNode(n-2).next = null;
            n--;
            return;
        }
        getNode(index-1).next = getNode(index+1);
        n--;
    }

    public MyLinkedList reverse() {
        LinkedListNode<T> previousNode = null;
        LinkedListNode<T> currentNode = head;
        LinkedListNode<T> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        LinkedListNode<T> node = head;
        while (node != null) {
            sb.append(node).append(", ");
            node = node.next;
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("}");
        return sb.toString();
    }

    private class LinkedListNode<T> {
        T value;
        LinkedListNode<T> next;

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
