package hw4_21000689_nguyenxuanloi.practice.ex8;

public class MyCircularQueue {
    private int[] queue;
    private int top = 0;
    private int count = 0;
    private final int DEFAULT_SIZE = 100;

    public MyCircularQueue() {
        queue = new int[DEFAULT_SIZE];
    }
    public MyCircularQueue(int capacity) {
        queue = new int[capacity];
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return false;
        }
        queue[(top + count) % queue.length] = value;
        count++;
        return true;
    }
    public boolean dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return false;
        }
        queue[top] = -1;
        top = (top + 1) % queue.length;
        count--;
        return true;
    }
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[top];
    }
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[(top + count - 1) % queue.length];
    }

    public int size() {
        return count;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == queue.length;
    }
}
