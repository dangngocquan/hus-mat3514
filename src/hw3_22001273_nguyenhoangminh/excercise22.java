package hw3_22001273_nguyenhoangminh;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

import java.util.Scanner;

public class excercise22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleLinkedList<Integer> intList = new SimpleLinkedList<>();
        System.out.print("Enter the length of the array: ");
        int length = input.nextInt();
        for (int i = 1; i <= length; ++i) {
            intList.addBot(i);
        }
        System.out.print("Input k and x: ");
        int k = input.nextInt();
        int x = input.nextInt();
        intList.insert(x, k);
        System.out.println(intList);
    }
}
