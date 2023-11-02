package hw6_21000699_dangngocquan.exercise001.e;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class TestE2 extends AbstractTest<Double, String> {
    public TestE2(PriorityQueueInterface<Double, String> queue) {
        super(queue);
    }

    @Override
    public void run() {
        header();
        testSize(queue);
        testIsEmpty(queue);
        testInsert1(queue, new AbstractPriorityQueue.Entry<>(10.04, "Item A"));
        testInsert2(queue, 4.01, "Item B");
        testInsert2(queue, 7.14, "Item C");
        testMin(queue);
        testRemoveMin(queue);
        testInsert2(queue, 1.04, "Item D");
        testInsert2(queue, 5.01, "Item E");
        testInsert2(queue, 3.01, "Item F");
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
        System.out.println("\nTEST 2");
    }
}
