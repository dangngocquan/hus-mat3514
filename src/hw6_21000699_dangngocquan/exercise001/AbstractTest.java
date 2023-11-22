package hw6_21000699_dangngocquan.exercise001;

import hw6_21000699_dangngocquan.base.EntryInterface;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;

public abstract class AbstractTest<K, E> {
    protected PriorityQueueInterface<K, E> queue;

    public AbstractTest(PriorityQueueInterface<K, E> queue) {
        this.queue = queue;
    }

    public abstract void run();

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

    public void testSize(PriorityQueueInterface<K, E> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "size()",
                queue.size(),
                queue
        );
    }

    public void testIsEmpty(PriorityQueueInterface<K, E> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "isEmpty()",
                queue.isEmpty(),
                queue
        );
    }

    public void testInsert1(
            PriorityQueueInterface<K, E> queue,
            EntryInterface<K,E> entry) {
        queue.insert(entry);
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                String.format("insert(%s)", entry),
                "",
                queue
        );
    }

    public void testInsert2(
            PriorityQueueInterface<K, E> queue,
            K key, E value) {
        queue.insert(key, value);
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                String.format("insert(key=%s, value=%s)", key, value),
                "",
                queue
        );
    }

    public void testMin(PriorityQueueInterface<K, E> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "min()",
                queue.min(),
                queue
        );
    }

    public void testRemoveMin(PriorityQueueInterface<K, E> queue) {
        System.out.printf(
                "%-40s  %-30s  %-60s\n",
                "removeMin()",
                queue.removeMin(),
                queue
        );
    }
}
