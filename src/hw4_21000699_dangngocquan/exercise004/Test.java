package hw4_21000699_dangngocquan.exercise004;

public class Test {
    public void run() {
        testArrayQueue();
        testLinkedListQueue();
    }

    public void testArrayQueue() {
        System.out.println("\nTEST ARRAY QUEUE");
        QueueInterface<Integer> queue = new ArrayQueue();
        testQueue(queue);
    }

    public void testLinkedListQueue() {
        System.out.println("\nTEST LINKED LIST QUEUE");
        QueueInterface<Integer> queue = new LinkedListQueue<>();
        testQueue(queue);
    }

    public void testQueue(QueueInterface<Integer> queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "Action",
                "Return",
                "Queue"
        );
        System.out.println("\t------------------------------------------------------------------------");

        testSize(queue);
        testIsEmpty(queue);
        testEnqueue(queue, 1);
        testEnqueue(queue, 2);
        testEnqueue(queue, 3);
        testSize(queue);
        testIsEmpty(queue);
        testFirst(queue);
        testLast(queue);
        testDequeue(queue);
        testDequeue(queue);
        testLast(queue);
        testFirst(queue);
        testDequeue(queue);
        testLast(queue);
        testFirst(queue);

    }

    public void testEnqueue(QueueInterface queue, Object o) {
        queue.enqueue(o);
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                String.format("enqueue(%s)", o),
                "",
                queue
        );
    }

    public void testDequeue(QueueInterface queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "dequeue()",
                queue.dequeue(),
                queue
        );
    }

    public void testSize(QueueInterface queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "size()",
                queue.size(),
                queue
        );
    }

    public void testFirst(QueueInterface queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "first()",
                queue.first(),
                queue
        );
    }

    public void testLast(QueueInterface queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "last()",
                queue.last(),
                queue
        );
    }

    public void testIsEmpty(QueueInterface queue) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "isEmpty()",
                queue.isEmpty(),
                queue
        );
    }
}
