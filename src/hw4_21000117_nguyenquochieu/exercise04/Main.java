package hw4_21000117_nguyenquochieu.exercise04;


public class Main {
    public static void main(String[] args) {
        System.out.println("Test Array Queue");
        testArrayQueue();
        System.out.println("-------------------");
        System.out.println("Test Linked List Queue");
        testLinkedListQueue();
        System.out.println("--------------------");
    }
    private static void testArrayQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("This");
        arrayQueue.enqueue("is");
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("testing");
        arrayQueue.enqueue("program");
        System.out.println("All elements in the queue: ");
        for (String element : arrayQueue) System.out.println(element);
        System.out.println("Remove top element: " + arrayQueue.dequeue());
        System.out.println("All elements in the queue: ");
        for (String element : arrayQueue) System.out.println(element);
    }

    private static void testLinkedListQueue() {
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue("Hello");
        linkedListQueue.enqueue("This");
        linkedListQueue.enqueue("is");
        linkedListQueue.enqueue("a");
        linkedListQueue.enqueue("testing");
        linkedListQueue.enqueue("program");
        System.out.println("All elements in the queue: ");
        for (String element : linkedListQueue) System.out.println(element);
        System.out.println("Remove top element: " + linkedListQueue.dequeue());
        System.out.println("All elements in the queue: ");
        for (String element : linkedListQueue) System.out.println(element);
    }
}
