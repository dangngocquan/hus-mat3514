package hw4_21000676_damhaidang.ex4;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        System.out.println("Kiểm tra các phương thức của ArrayQueue: ");
        testArrayQueue();

        System.out.println("----------------------------------------------------------------");

        System.out.println("Kiểm tra các phương thức của LinkedListQueue: ");
        testLinkedListQueue();
    }

    public static <E> void printQueue(QueueInterface<E> queue ) {
        Iterator<E> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void testArrayQueue() {
        QueueInterface<Integer> queue = new ArrayQueue<>();
        System.out.println("Test enqueue");
        for (int i = 0; i <10; i++) {
            queue.enqueue(i);
        }
        printQueue(queue);
        System.out.println("Queue có trống không? " + queue.isEmpty());

        System.out.println("Test dequeue");
        queue.dequeue();
        printQueue(queue);
    }

    public static void testLinkedListQueue() {
        QueueInterface<Integer> queue = new LinkedListQueue<>();
        System.out.println("Test enqueue");
        for (int i = 0; i <10; i++) {
            queue.enqueue(i);
        }
        printQueue(queue);
        System.out.println("Queue có trống không? " + queue.isEmpty());

        System.out.println("Test dequeue");
        queue.dequeue();
        printQueue(queue);
    }

}
