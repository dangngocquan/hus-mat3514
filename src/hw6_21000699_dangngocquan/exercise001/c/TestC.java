package hw6_21000699_dangngocquan.exercise001.c;

import hw6_21000699_dangngocquan.base.UnsortedLinkedPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTestABCD;

public class TestC extends AbstractTestABCD {
    public TestC() {
        super(new UnsortedLinkedPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST UNSORTED LINKED PRIORITY QUEUE");
    }
}
