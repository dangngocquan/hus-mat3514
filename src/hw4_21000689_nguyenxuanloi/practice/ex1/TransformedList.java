package hw4_21000689_nguyenxuanloi.practice.ex1;

public class TransformedList {
    public static void main(String[] args) throws Exception {
        QueueInterface<Integer> integers = new LinkedListQueue<>();
        for (int i = 1; i <= 10; i++) {
            integers.enqueue(i);
        }
        printQueue(integers);

        transformList(integers, 2);
        printQueue(integers);
    }

    static <E> void transformList(QueueInterface<E> queue, int k) throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("Queue is null.");
        }
        while (k > 0) {
            E temp = queue.dequeue();
            queue.enqueue(temp);
            k--;
        }
    }

    static <E> void printQueue(QueueInterface<E> queue) {
        for (E element: queue) {
            System.out.print(element + " -> ");
        }
        System.out.println();
    }
}
