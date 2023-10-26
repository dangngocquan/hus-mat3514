package hw4_21000506_nguyenthithanhhuong.ex04;

public class TestArrayQueue {
    public static void main(String[] args) {
        QueueInterface queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Result test: ");
        System.out.println("Queue: " + queue.toString());
        System.out.println("Test size: " + queue.size());
        System.out.println("Test first: " + queue.first());
        System.out.println("Test dequeue: " + queue.dequeue());
        System.out.println("Queue after use dequeue(): ");
        System.out.println("Queue: " + queue.toString());
        System.out.println("Queue size: " + queue.size());
    }

    //    Result test:
    //    Queue: [1, 2, 3]
    //    Test size: 3
    //    Test first: 1
    //    Test dequeue: 1
    //    Queue after use dequeue():
    //    Queue: [2, 3]
    //    Queue size: 2
}
