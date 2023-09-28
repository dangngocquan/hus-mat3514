package hw3_21000699_dangngocquan.exercise017;

public class Main {
     class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class circular_LinkedList {
         Node head, head1, head2;
         Node last = null;
    }

    class gfg
    {
        // Function  to split a circular LinkedList
        void splitList(circular_LinkedList list)
        {
            //DO NOT REMOVE THESE 3 LINES
            Node head = list.head;
            Node head1 = null;
            Node head2 = null;

            //Modify these head1 and head2 here, head is the starting point of our original linked list.
            int size = 0;
            Node currentNode = head;
            Node lastNode;
            do {
                size++;
                lastNode = currentNode;
                currentNode = currentNode.next;
            } while (currentNode != head);

            int size1 = (size+1)/2;
            currentNode = head;
            int index = 0;
            Node lastNode1 = currentNode;
            while (index++ < size1) {
                lastNode1 = currentNode;
                currentNode = currentNode.next;
            }
            head1 = head;
            lastNode1.next = head1;
            head2 = currentNode;
            lastNode.next = head2;

            //DO NOT REMOVE THESE 2 LINES
            list.head1 = head1;
            list.head2 = head2;
        }
    }
}
