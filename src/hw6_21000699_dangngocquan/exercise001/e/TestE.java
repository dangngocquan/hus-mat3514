package hw6_21000699_dangngocquan.exercise001.e;

import hw6_21000699_dangngocquan.base.SortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.base.SortedLinkedPriorityQueue;
import hw6_21000699_dangngocquan.base.UnsortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.base.UnsortedLinkedPriorityQueue;

public class TestE {
    public void run() {
        System.out.println("\n\nTEST UNSORTED ARRAY PRIORITY QUEUE");
        new TestE1(new UnsortedArrayPriorityQueue<>()).run();
        new TestE2(new UnsortedArrayPriorityQueue<>()).run();

        System.out.println("\n\nTEST SORTED ARRAY PRIORITY QUEUE");
        new TestE1(new SortedArrayPriorityQueue<>()).run();
        new TestE2(new SortedArrayPriorityQueue<>()).run();

        System.out.println("\n\nTEST UNSORTED LINKED PRIORITY QUEUE");
        new TestE1(new UnsortedLinkedPriorityQueue<>()).run();
        new TestE2(new UnsortedLinkedPriorityQueue<>()).run();

        System.out.println("\n\nTEST SORTED LINKED PRIORITY QUEUE");
        new TestE1(new SortedLinkedPriorityQueue<>()).run();
        new TestE2(new SortedLinkedPriorityQueue<>()).run();
    }
}
