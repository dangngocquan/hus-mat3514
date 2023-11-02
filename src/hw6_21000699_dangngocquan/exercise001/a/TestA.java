package hw6_21000699_dangngocquan.exercise001.a;

import hw6_21000699_dangngocquan.base.UnsortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTestABCD;

public class TestA extends AbstractTestABCD {
    public TestA() {
        super(new UnsortedArrayPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST UNSORTED ARRAY PRIORITY QUEUE");
    }
}
