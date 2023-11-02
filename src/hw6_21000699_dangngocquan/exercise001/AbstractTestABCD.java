package hw6_21000699_dangngocquan.exercise001;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;

public abstract class AbstractTestABCD extends AbstractTest<Integer, String> {
    public AbstractTestABCD(PriorityQueueInterface<Integer, String> queue) {
        super(queue);
    }

    @Override
    public void run() {
        header();
        testSize(queue);
        testIsEmpty(queue);
        testInsert1(queue, new AbstractPriorityQueue.Entry<>(10, "a"));
        testInsert2(queue, 4, "b");
        testInsert2(queue, 7, "c");
        testMin(queue);
        testRemoveMin(queue);
        testInsert2(queue, 1, "d");
        testInsert2(queue, 5, "e");
        testInsert2(queue, 3, "f");
        testSize(queue);
        testIsEmpty(queue);
        testMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
        testRemoveMin(queue);
    }
}
