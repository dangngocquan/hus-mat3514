package hw3_22001273_nguyenhoangminh.excercise10;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

public class ReverseList {

    public static SimpleLinkedList<Integer> reverse(SimpleLinkedList<Integer> list) {
        SimpleLinkedList<Integer> newList = new SimpleLinkedList<>();
        for (int i = 0; i < list.size(); ++i) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> test = new SimpleLinkedList<>();
        for (int i = 0; i < 10; ++i) {
            test.addBot(i);
        }
        System.out.println(test);
        SimpleLinkedList<Integer> newTest = ReverseList.reverse(test);
        System.out.println("Reversed List:");
        System.out.println(newTest);
    }
}
