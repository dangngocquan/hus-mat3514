package hw4_22001273_nguyenhoangminh.excercise4;

public class TestLinkQueue {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(0);
        System.out.println(queue);
        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);

        // Test iterator
        for (int i : queue) {
            System.out.print(i + " ");
        }
    }
}
