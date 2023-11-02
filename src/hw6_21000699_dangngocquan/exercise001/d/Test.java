package hw6_21000699_dangngocquan.exercise001.d;

import hw6_21000699_dangngocquan.base.SortedLinkedPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class Test extends AbstractTest {
    public Test() {
        super(new SortedLinkedPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST SORTED LINKED PRIORITY QUEUE");
    }
}
