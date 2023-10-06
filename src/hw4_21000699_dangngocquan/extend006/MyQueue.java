package hw4_21000699_dangngocquan.extend006;

class MyQueue {
    class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a) {
        // Your code here
        QueueNode node = new QueueNode(a);
        if (front == null) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    //Function to pop front element from the queue.
    int pop() {
        // Your code here
        if (front == null) return -1;
        int data = front.data;
        if (front.next == null) {
            front = null;
            rear = null;
            return data;
        }
        front = front.next;
        return data;
    }
}
