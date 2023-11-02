package hw6_21000699_dangngocquan.exercise001;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.base.EntryInterface;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;

public abstract class AbstractTest {
    PriorityQueueInterface<Integer, String> queue;

    public AbstractTest(PriorityQueueInterface<Integer, String> queue) {
        this.queue = queue;
    }

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

    public abstract void printNameTest();

    public void header() {
        this.printNameTest();
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "Action",
                "Return",
                "Priority queue after action"
        );
        System.out.println("-".repeat(134));
    }

    public void testSize(PriorityQueueInterface<Integer, String> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "size()",
                queue.size(),
                queue
        );
    }

    public void testIsEmpty(PriorityQueueInterface<Integer, String> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "isEmpty()",
                queue.isEmpty(),
                queue
        );
    }

    public void testInsert1(
            PriorityQueueInterface<Integer, String> queue,
            EntryInterface<Integer,String> entry) {
        queue.insert(entry);
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                String.format("insert(%s)", entry),
                "",
                queue
        );
    }

    public void testInsert2(
            PriorityQueueInterface<Integer, String> queue,
            Integer key, String value) {
        queue.insert(key, value);
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                String.format("insert(key=%s, value=%s)", key, value),
                "",
                queue
        );
    }

    public void testMin(PriorityQueueInterface<Integer, String> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "min()",
                queue.min(),
                queue
        );
    }

    public void testRemoveMin(PriorityQueueInterface<Integer, String> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "removeMin()",
                queue.removeMin(),
                queue
        );
    }
}
