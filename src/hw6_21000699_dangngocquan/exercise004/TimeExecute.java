package hw6_21000699_dangngocquan.exercise004;

import hw6_21000699_dangngocquan.base.PriorityQueueInterface;

public class TimeExecute<K, E> {
    public long timeExecuteInsert(PriorityQueueInterface<K, E> queue, K key, E value) {
        long start = System.currentTimeMillis();
        queue.insert(key, value);
        return System.currentTimeMillis() - start;
    }

    public long timeExecuteRemoveMin(PriorityQueueInterface<K, E> queue) {
        long start = System.currentTimeMillis();
        queue.removeMin();
        return System.currentTimeMillis() - start;
    }
}
