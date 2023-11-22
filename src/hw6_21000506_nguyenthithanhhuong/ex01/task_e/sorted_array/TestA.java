package hw6_21000506_nguyenthithanhhuong.ex01.task_e.sorted_array;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;
import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.SortedArrayPriorityQueue;
import hw6_21000506_nguyenthithanhhuong.ex01.test_case.TestEA;

public class TestA {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, Integer> priorityQueue = new SortedArrayPriorityQueue<>();

        new TestEA(priorityQueue);
    }
}

//    Result:
//    1. Test isEmpty(): true
//    2. Test size(): 0
//    3. Test insert(K k, E e):
//    insert(1, "a"): {(1,1)}
//    insert(3, "c"): {(1,1), (3,3)}
//    insert(5, "e"): {(1,1), (3,3), (5,5)}
//    insert(2, "b"): {(1,1), (2,2), (3,3), (5,5)}
//    insert(4, "d"): {(1,1), (2,2), (3,3), (4,4), (5,5)}
//    4. Test isEmpty() after use insert(): false
//    5. Test size() after use insert(): 5
//    6. Test min(): (1,1)
//    7. Test removeMin():
//        min(): (1,1)
//        Priority unsorted array after removeMin(): {(2,2), (3,3), (4,4), (5,5)}
