package hw3_22001273_nguyenhoangminh;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

import java.util.Scanner;

public class excercise23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleLinkedList<Integer> intList = new SimpleLinkedList<>();
        System.out.print("Enter the length of the list: ");
        int length = input.nextInt();
        for (int i = 1; i <= length; ++i) {
            intList.addBot(i);
        }
        System.out.print("Enter the index of removed element: ");
        int k = input.nextInt();
        System.out.println("Removed: " + intList.remove(k));
        System.out.print(intList);
    }
}
