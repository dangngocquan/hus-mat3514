package hw3_21000699_dangngocquan.exercise015;

public class Main {
    static class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            next = prev = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append(data).append(", ");
            Node node = next;
            while (node != null) {
                sb.append(node.data).append(", ");
                node = node.next;
            }
            if (sb.length() > 1) {
                sb.delete(sb.length()-2, sb.length());
            }
            sb.append("}");
            return sb.toString();
        }
    }

    class GfG {
        static Node rotate(Node headRef, int k) {
            // Your code here
            int size = 0;
            Node lastNode = null; // to find last node
            Node currentNode = headRef;
            while (currentNode != null) {
                lastNode = currentNode;
                currentNode = currentNode.next;
                size++;
            }

            k %= size;
            if (k == 0) return headRef;

            int index = 0;

            Node nodeK = headRef;
            while (index++ < k) {
                nodeK = nodeK.next;
            }

            nodeK.prev.next = null;
            nodeK.prev = null;
            lastNode.next = headRef;
            headRef.prev = lastNode;

            return nodeK;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.prev = node3;
        node3.prev = node2;
        node2.prev = node1;
        Node head = node1;
        System.out.println(head);
        // {1, 2, 3, 4}
        head = GfG.rotate(head, 3);
        System.out.println(head);
        // {4, 1, 2, 3}
        head = GfG.rotate(head, 1);
        System.out.println(head);
        // {1, 2, 3, 4}
        head = GfG.rotate(head, 1);
        System.out.println(head);
        // {2, 3, 4, 1}


    }


}
