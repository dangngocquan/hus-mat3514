package hw6_21000506_nguyenthithanhhuong.ex01.test_case;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;

public class TestEB {
    public TestEB(PriorityQueueInterface<Integer, String> priorityQueue) {
        Product p01 = new Product(1, "product01");
        Product p02 = new Product(3, "product03");
        Product p03 = new Product(4, "product04");
        Product p04 = new Product(2, "product02");

        priorityQueue.insert(p01.getPrice(), p01.getName());
        priorityQueue.insert(p02.getPrice(), p02.getName());
        priorityQueue.insert(p03.getPrice(), p03.getName());
        priorityQueue.insert(p04.getPrice(), p04.getName());

        System.out.print("Priority Queue: ");
        System.out.println(priorityQueue);

        System.out.print("1. Test isEmpty(): ");
        System.out.println(priorityQueue.isEmpty());

        System.out.print("2. Test size(): ");
        System.out.println(priorityQueue.size());

        System.out.print("3. Test min(): ");
        System.out.println(priorityQueue.min());

        System.out.println("4. Test removeMin(): ");
        System.out.print("\tmin(): ");
        System.out.println(priorityQueue.removeMin());
        System.out.print("\tpriority queue after removeMin(): ");
        System.out.println(priorityQueue);
    }
}
