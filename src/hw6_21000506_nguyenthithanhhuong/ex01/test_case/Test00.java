package hw6_21000506_nguyenthithanhhuong.ex01.test_case;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;

public class Test00 {
    public Test00(PriorityQueueInterface<Integer, String> priorityQueue) {
        System.out.print("1. Test isEmpty(): ");
        System.out.println(priorityQueue.isEmpty());

        System.out.print("2. Test size(): ");
        System.out.println(priorityQueue.size());

        System.out.println("3. Test insert(K k, E e):");
        System.out.print("\tinsert(1, \"a\"): ");
        priorityQueue.insert(1, "a");
        System.out.println(priorityQueue);
        System.out.print("\tinsert(3, \"c\"): ");
        priorityQueue.insert(3, "c");
        System.out.println(priorityQueue);
        System.out.print("\tinsert(5, \"e\"): ");
        priorityQueue.insert(5, "e");
        System.out.println(priorityQueue);
        System.out.print("\tinsert(2, \"b\"): ");
        priorityQueue.insert(2, "b");
        System.out.println(priorityQueue);
        System.out.print("\tinsert(4, \"d\"): ");
        priorityQueue.insert(4, "d");
        System.out.println(priorityQueue);

        System.out.print("4. Test isEmpty() after use insert(): ");
        System.out.println(priorityQueue.isEmpty());

        System.out.print("5. Test size() after use insert(): ");
        System.out.println(priorityQueue.size());

        System.out.print("6. Test min(): ");
        System.out.println(priorityQueue.min().toString());

        System.out.println("7. Test removeMin(): ");
        System.out.print("\tremoveMin(): ");
        System.out.println(priorityQueue.removeMin().toString());
        System.out.print("\tPriority queue after first removeMin() : ");
        System.out.println(priorityQueue);

        System.out.print("\tremoveMin(): ");
        System.out.println(priorityQueue.removeMin().toString());
        System.out.print("\tPriority queue after second removeMin(): ");
        System.out.println(priorityQueue);
    }
}
