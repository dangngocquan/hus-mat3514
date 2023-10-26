package hw4_21000709_hoangtuantu.exercise04;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E> {
    class Node{
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    @Override
    public void enqueue(E element) {
        Node node = new Node(element);
        if (head == null){
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        size++;

    }

    @Override
    public E dequeue() {
        if (head == null){
            throw new NullPointerException("No element in queue!");
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator(head);
    }

    class QueueIterator implements Iterator<E> {
        private Node node = head;

        public QueueIterator(Node node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E data = node.data;
            node = node.next;
            return data;
        }
    }

    @Override
    public String toString(){
        if (isEmpty()){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Node node = head;
        while (node.next != null){
            result.append(node.data).append(" ");
            node = node.next;
        }
        result.append(node.data);
        return result.toString();
    }
}
