package hw3_21000676_damhaidang;

public class Ex8 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class Solution {
        //Function to find the data of nth node from the end of a linked list.
        int getNthFromLast(Node head, int n) {
            // Your code here
            int len = lengthOfTheList(head);

            // check if value of n is not more than length of the linked list
            // if value of n is more than length of the list then return -1
            if (n > len) {
                return -1;
            }

            Node temp = head;

            // get the (len - n + 1)th node from the beginning
            for (int i = 1; i < len - n + 1; i++)
                temp = temp.next;

            return temp.data;
        }

        int lengthOfTheList(Node head) {
            Node temp = head;
            int len = 0;
            // count the number of nodes in Linked List
            while (temp != null) {
                temp = temp.next;
                len++;
            }
            return len;
        }
    }
}
