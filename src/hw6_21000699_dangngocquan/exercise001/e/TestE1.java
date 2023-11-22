package hw6_21000699_dangngocquan.exercise001.e;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class TestE1 extends AbstractTest<Integer, Integer> {
    public TestE1(PriorityQueueInterface<Integer, Integer> queue) {
        super(queue);
    }

    @Override
    public void run() {
        header();
        testSize(queue);
        testIsEmpty(queue);
        testInsert1(queue, new AbstractPriorityQueue.Entry<>(10, 10));
        testInsert2(queue, 4, 4);
        testInsert2(queue, 7, 7);
        testMin(queue);
        testRemoveMin(queue);
        testInsert2(queue, 1, 1);
        testInsert2(queue, 5, 5);
        testInsert2(queue, 3, 3);
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
        System.out.println("\nTEST 1");
    }
}
