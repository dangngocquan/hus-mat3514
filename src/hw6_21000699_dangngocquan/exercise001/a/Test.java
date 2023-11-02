package hw6_21000699_dangngocquan.exercise001.a;

import hw6_21000699_dangngocquan.base.UnsortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise001.AbstractTest;

public class Test extends AbstractTest {
    public Test() {
        super(new UnsortedArrayPriorityQueue<>());
    }

    @Override
    public void printNameTest() {
        System.out.println("TEST UNSORTED ARRAY PRIORITY QUEUE");
    }
}
