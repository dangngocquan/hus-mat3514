package hw3_21000699_dangngocquan.exercise008;

public class Main {
    class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    class Solution {
        //Function to find the data of nth node from the end of a linked list.
        int getNthFromLast(Node head, int n) {
            // Your code here
            Node node = head;
            int size = 0;
            while (node != null) {
                size++;
                node = node.next;
            }

            node = head;
            int index = size - n;
            if (index < 0 || index >= size) return -1;
            while (index -- > 0) {
                node = node.next;
            }
            return node.data;
        }
    }
}
