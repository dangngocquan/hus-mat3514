package hw3_21000699_dangngocquan.exercise014;

public class Main {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    class GfG {
        //Function to insert a new node at given position in doubly linked list.
        void addNode(Node headRef, int pos, int data) {
            // Your code here
            Node currentNode = headRef;
            int index = 0;
            while (index < pos && currentNode != null) {
                currentNode = currentNode.next;
                index++;
            }

            if (index == pos && currentNode != null) {
                Node node = new Node(data);
                node.prev = currentNode;
                node.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = node;
                }
                currentNode.next = node;
            }
        }
    }

}
