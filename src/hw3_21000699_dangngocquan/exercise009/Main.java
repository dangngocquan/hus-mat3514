package hw3_21000699_dangngocquan.exercise009;

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
    // complete the below function
    class Solution {
        public static int count(Node head, int searchFor) {
            //code here
            int count = 0;
            while (head != null) {
                if (head.data == searchFor) count++;
                head = head.next;
            }
            return count;
        }
    }
}
