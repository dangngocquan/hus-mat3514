package hw4_21000117_nguyenquochieu.exercise04;
import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node header;
    @Override
    public void enqueue(E element) {
        if (header == null) header = new Node(element);
        else {
            Node currentNode = header;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.setNext(new Node(element));
        }
    }

    @Override
    public E dequeue() {
        if (header == null) return null;
        E element = header.element;
        header = header.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private Node currentNode = header;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E element = currentNode.getElement();
                currentNode = currentNode.next;
                return element;
            }
        };
        return iterator;
    }
}
