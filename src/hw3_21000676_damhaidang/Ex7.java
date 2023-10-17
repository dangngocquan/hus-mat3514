package hw3_21000676_damhaidang;

public class Ex7 {
    class Node{
        int data;
        Node next;
        Node(int a){  data = a; next = null; }
    }
    class Solution
    {
        //Function to count nodes of a linked list.
        public static int getCount(Node head)
        {
            //Code here
            int count = 1;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }
    }
}
