package hw3_22001273_nguyenhoangminh.excercise21;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

import java.util.Scanner;

public class LinkedListPrint {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> intList = new SimpleLinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Input the length of the list: ");
        int length = input.nextInt();
        for (int i = 1; i <= length; ++i) {
            intList.addBot(i);
        }
        System.out.print(intList);
    }
}
