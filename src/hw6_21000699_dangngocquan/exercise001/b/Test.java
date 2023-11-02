package hw6_21000699_dangngocquan.exercise001.b;

import hw6_21000699_dangngocquan.base.SortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class Test extends AbstractTest {
    public Test() {
        super(new SortedArrayPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST SORTED ARRAY PRIORITY QUEUE");
    }
}
