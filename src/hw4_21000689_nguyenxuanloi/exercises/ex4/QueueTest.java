package hw4_21000689_nguyenxuanloi.exercises.ex4;

import java.util.Random;

public class QueueTest {
    public static void main(String[] args) {
//        testIntegerQueue();
        testDoubleQueue();
    }

    static void testIntegerQueue() {
        QueueInterface<Integer> queue = new ArrayQueue<>(10);
        for (int i = 1; i < 10; i++) {
            queue.enqueue(i);
        }
        printQueue(queue);

        queue.enqueue(100);
        printQueue(queue);

        queue.dequeue();
        printQueue(queue);

        queue.enqueue(11);
        queue.enqueue(12);
        printQueue(queue);
    }

    static void testDoubleQueue() {
        QueueInterface<Double> queue = new ArrayQueue<>();
        for (int i = 1; i < 10; i++) {
            queue.enqueue(new Random().nextDouble(100));
        }
        printQueue(queue);

        queue.enqueue(100.0);
        printQueue(queue);

        queue.dequeue();
        printQueue(queue);

        queue.enqueue(28.8);
        queue.enqueue(12.6);
        printQueue(queue);
    }

    static <E> void printQueue(QueueInterface<E> queue) {
        for (E element: queue) {
            System.out.println(element);
        }
        System.out.println();
    }
}
