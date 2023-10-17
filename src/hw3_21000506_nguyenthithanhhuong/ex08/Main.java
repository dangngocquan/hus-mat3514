package hw3_21000506_nguyenthithanhhuong.ex08;

public class Main {
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    class Solution {
        int getNthFromLast(Node head, int n) {
            Node node = head;

            int count = 0;
            while (node != null) {
                count++;
                node = node.next;
            }

            node = head;

            int index = count - n;
            if (index < 0 || index >= count) return -1;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node.data;
        }
    }
}
