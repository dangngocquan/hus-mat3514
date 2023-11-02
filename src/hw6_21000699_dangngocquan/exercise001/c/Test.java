package hw6_21000699_dangngocquan.exercise001.c;

import hw6_21000699_dangngocquan.base.UnsortedLinkedPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class Test extends AbstractTest {
    public Test() {
        super(new UnsortedLinkedPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST UNSORTED LINKED PRIORITY QUEUE");
    }
}
