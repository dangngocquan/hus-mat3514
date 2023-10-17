package hw3_22001273_nguyenhoangminh.excercise8;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

public class NthElement {

    public static Integer getNthFromBot(SimpleLinkedList<Integer> list, int n) {
        return list.get(list.size() - n);
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> test = new SimpleLinkedList<>();
        for (int i = 0; i < 10; ++i) {
            test.addBot(i);
        }
        System.out.println(test);
        System.out.println("The Nth element from bottom is: " + NthElement.getNthFromBot(test, 3));
    }
}
