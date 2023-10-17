package hw3_21000506_nguyenthithanhhuong.ex07;

import java.util.LinkedList;
import java.util.List;

public class Main {
    class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }

    class Solution {
        public static int getCount(Node head) {
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            return count;
        }
    }
}
