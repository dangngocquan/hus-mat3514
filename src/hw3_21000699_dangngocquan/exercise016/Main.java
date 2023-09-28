package hw3_21000699_dangngocquan.exercise016;

public class Main {
    class Node{
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

    }

    class Solution {
        /* Function to print nodes in a given Circular linked list */
        void printList(Node head) {
            // Your code here
            StringBuilder sb = new StringBuilder("");
            Node node = head;
            do {
                sb.append(node.data).append(" ");
                node = node.next;
            } while (node != null && node != head);
            sb.delete(sb.length()-1, sb.length());
            System.out.print(sb.toString());
        }
    }
}
