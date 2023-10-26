package hw4_20001970_duongtuanson.Bai4;
import java.util.Iterator;

    public class LinkedListQueue<E> implements QueueInterface<E> {
        private class Node {
            E element;
            Node next;
        }

        private Node front = null;
        private Node rear = null;

        @Override
        public void enqueue(E data) {
            Node newNode = new Node();
            newNode.element = data;
            newNode.next = null;

            if (this.rear == null) {
                this.front = newNode;
                this.rear = newNode;
            } else {
                this.rear.next = newNode;
                this.rear = newNode;
            }
        }

        @Override
        public E dequeue() {
            if (this.front == null) {
                return null;
            }

            E temp = this.front.element;
            this.front = this.front.next;
            if (this.front == null) {
                this.rear = null;
            }
            return temp;
        }

        @Override
        public boolean isEmpty() {
            return this.front == null;
        }

        @Override
        public Iterator<E> iterator() {
            return new LinkedListQueueIterator();
        }

        class LinkedListQueueIterator implements Iterator<E> {
            private Node current = front;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E temp = this.current.element;
                this.current = this.current.next;
                return temp;
            }
        }
    }
