package hw4_21000676_damhaidang.practice10;

class MyCircularDeque {
    class Node {
        int data;
        Node next = null;
        Node prev = null;

        public Node(int data) {
            this.data = data;
        }
    }
    private int maxSize;
    private int currSize;
    private Node front = null;
    private Node rear = null;

    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.currSize = 0;
        front = rear = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        if (front == null)
            rear = front = node;
        else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        if (rear == null)
            front = rear = node;
        else {
            node.prev = rear;
            rear.next = node;
            rear = node;
        }
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node temp = front;
        front = front.next;

        // If only one element was present
        if (front == null)
            rear = null;
        else
            front.prev = null;

        // Decrements count of elements by 1
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node temp = rear;
        rear = rear.prev;

        // If only one element was present
        if (rear == null)
            front = null;
        else
            rear.next = null;

        // Decrements count of elements by 1
        currSize--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return front.data;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return rear.data;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }
}
