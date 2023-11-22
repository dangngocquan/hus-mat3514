package hw6_21000699_dangngocquan.exercise001.b;

import hw6_21000699_dangngocquan.base.SortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTestABCD;

public class TestB extends AbstractTestABCD {
    public TestB() {
        super(new SortedArrayPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST SORTED ARRAY PRIORITY QUEUE");
    }
}
