package hw6_21000699_dangngocquan.exercise002;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.base.MinHeapPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class Test extends AbstractTest<Integer, String> {
    public Test() {
        super(new MinHeapPriorityQueue<>());
    }

    @Override
    public void run() {
        header();
        testSize(queue);
        testIsEmpty(queue);
        testInsert1(queue, new AbstractPriorityQueue.Entry<>(5, "a"));
        testInsert2(queue, 3, "b");
        testInsert2(queue, 1, "c");
        testMin(queue);
        testRemoveMin(queue);
        testInsert2(queue, 4, "d");
        testInsert2(queue, 2, "e");
        testInsert2(queue, 6, "f");
        testSize(queue);
        testIsEmpty(queue);
        testMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST MIN HEAP PRIORITY QUEUE");
    }
}
