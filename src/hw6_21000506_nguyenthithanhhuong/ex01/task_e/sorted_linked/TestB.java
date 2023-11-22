package hw6_21000506_nguyenthithanhhuong.ex01.task_e.sorted_linked;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;
import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.SortedLinkedPriorityQueue;
import hw6_21000506_nguyenthithanhhuong.ex01.test_case.TestEB;

public class TestB {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> priorityQueue = new SortedLinkedPriorityQueue<>();

        new TestEB(priorityQueue);
    }
}

//    Result:
//    Priority Queue: {(1,product01), (2,product02), (3,product03), (4,product04)}
//    1. Test isEmpty(): false
//    2. Test size(): 4
//    3. Test min(): (1,product01)
//    4. Test removeMin():
//        min(): (1,product01)
//        priority queue after removeMin(): {(2,product02), (3,product03), (4,product04)}