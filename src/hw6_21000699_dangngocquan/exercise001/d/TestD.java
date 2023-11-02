package hw6_21000699_dangngocquan.exercise001.d;

import hw6_21000699_dangngocquan.base.SortedLinkedPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTestABCD;

public class TestD extends AbstractTestABCD {
    public TestD() {
        super(new SortedLinkedPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST SORTED LINKED PRIORITY QUEUE");
    }
}
