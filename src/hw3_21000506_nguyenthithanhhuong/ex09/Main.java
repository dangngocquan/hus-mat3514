package hw3_21000506_nguyenthithanhhuong.ex09;

public class Main {
    class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    class Solution {
        public static int count(Node head, int search_for) {
            int count = 0;
            while (head != null) {
                if (head.data == search_for) {
                    count++;
                }
                head = head.next;
            }
            return count;
        }
    }
}
