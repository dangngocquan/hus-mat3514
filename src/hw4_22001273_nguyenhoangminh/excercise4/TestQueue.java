package hw4_22001273_nguyenhoangminh.excercise4;

public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.enqueue(0);
        System.out.println(queue);
        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        System.out.println(queue);

        // Test enlarge queue method
        queue.enqueue(12);
        System.out.println(queue);
        System.out.println(queue.getLength());

        // Using iterator
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println();
        ArrayQueue<Integer> a = new ArrayQueue<>(0);

        for (int i = 0; i < 10; i++) {
            a.enqueue(i);
        }

        System.out.println(a);

    }
}
