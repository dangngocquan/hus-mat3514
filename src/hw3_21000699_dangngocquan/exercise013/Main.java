package hw3_21000699_dangngocquan.exercise013;

public class Main {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a,int b) {
            coeff =a;
            pow=b;
            next = null;
        }
    }

    //Print the polynomial formed by adding both LL in the function itself.
    class Solution {
        public static Node addPolynomial(Node p1,Node p2) {
            //Add your code here.
            Node node1 = p1;
            Node node2 = p2;
            Node head = new Node(0, 0);
            Node node = head;
            while (node1 != null && node2 != null) {
                int pow;
                int coeff;
                if (node1.pow == node2.pow) {
                    pow = node1.pow;
                    coeff = node1.coeff + node2.coeff;
                    node1 = node1.next;
                    node2 = node2.next;
                } else if (node1.pow > node2.pow) {
                    pow = node1.pow;
                    coeff = node1.coeff;
                    node1 = node1.next;
                } else {
                    pow = node2.pow;
                    coeff = node2.coeff;
                    node2 = node2.next;
                }
                node.next = new Node(coeff, pow);
                node = node.next;
            }
            while (node1 != null) {
                int pow = node1.pow;
                int coeff = node1.coeff;
                node1 = node1.next;
                node.next = new Node(coeff, pow);
                node = node.next;
            }
            while (node2 != null) {
                int pow = node2.pow;
                int coeff = node2.coeff;
                node2 = node2.next;
                node.next = new Node(coeff, pow);
                node = node.next;
            }
            return head.next;
        }
    }
}
