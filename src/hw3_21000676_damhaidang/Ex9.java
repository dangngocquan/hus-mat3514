package hw3_21000676_damhaidang;

public class Ex9 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    class Solution {
        public static int count(Node head, int search_for) {
            //code here
            Node temp = head;
            int count = 0;
            do {
                if (temp.data == search_for)
                    count++;
                temp = temp.next;
            } while (temp != null);
            return count;
        }
    }
}
