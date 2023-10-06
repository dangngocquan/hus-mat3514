package hw4_21000699_dangngocquan.exercise004;

public class Main {
    public static void main(String[] args) {
        new Test().run();

        // Sample

        /*

        TEST ARRAY QUEUE
            Action               Return          Queue
            ------------------------------------------------------------------------
            size()               0               []
            isEmpty()            true            []
            enqueue(1)                           [1]
            enqueue(2)                           [1, 2]
            enqueue(3)                           [1, 2, 3]
            size()               3               [1, 2, 3]
            isEmpty()            false           [1, 2, 3]
            first()              1               [1, 2, 3]
            last()               3               [1, 2, 3]
            dequeue()            1               [2, 3]
            dequeue()            2               [3]
            last()               3               [3]
            first()              3               [3]
            dequeue()            3               []
            last()               null            []
            first()              null            []

        TEST LINKED LIST QUEUE
            Action               Return          Queue
            ------------------------------------------------------------------------
            size()               0               []
            isEmpty()            true            []
            enqueue(1)                           [1]
            enqueue(2)                           [1, 2]
            enqueue(3)                           [1, 2, 3]
            size()               3               [1, 2, 3]
            isEmpty()            false           [1, 2, 3]
            first()              1               [1, 2, 3]
            last()               3               [1, 2, 3]
            dequeue()            1               [2, 3]
            dequeue()            2               [3]
            last()               3               [3]
            first()              3               [3]
            dequeue()            3               []
            last()               null            []
            first()              null            []

        */
    }
}
