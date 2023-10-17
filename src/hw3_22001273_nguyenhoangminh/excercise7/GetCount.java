package hw3_22001273_nguyenhoangminh.excercise7;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

public class GetCount {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> testCount = new SimpleLinkedList<>();
        System.out.println("Numbers of elements: " + testCount.size());
        for (int i = 0; i < 10; ++i) {
            testCount.addBot(i);
        }
        System.out.println(testCount);
        System.out.println("Numbers of elements: " + testCount.size());
    }
}
