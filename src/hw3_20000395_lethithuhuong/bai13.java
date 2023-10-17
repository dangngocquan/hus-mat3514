package hw3_20000395_lethithuhuong;

class bai13 {
    public static void main(String[] args)
    {
        Node head = new Node(5, 3);
        Polynomial.insert(head, 4, 2);
        Polynomial.insert(head, 4, 1);
        Node head2 = new Node(6, 3);
        Polynomial.insert(head2, 4, 1);
        Polynomial.printList(head);
        System.out.println();
        Polynomial.printList(head2);
        System.out.println("\n Addition:");
        Polynomial.addPolynomials(head, head2);
    }

    public static class Polynomial {

        public static void addPolynomials(Node head1,
                                          Node head2)
        {
            if (head1 == null && head2 == null)
                return;
            else if (head1.power == head2.power) {
                System.out.print(" " + (head1.coeff + head2.coeff)
                        + "x^" + head1.power + " ");
                addPolynomials(head1.next, head2.next);
            }
            else if (head1.power > head2.power) {
                System.out.print(" " + head1.coeff + "x^"
                        + head1.power + " ");
                addPolynomials(head1.next, head2);
            }
            else {
                System.out.print(" " + head2.coeff + "x^"
                        + head2.power + " ");
                addPolynomials(head1, head2.next);
            }
        }
        public static void insert(Node head, int coeff,
                                  int power)
        {
            Node new_node = new Node(coeff, power);
            while (head.next != null) {
                head = head.next;
            }
            head.next = new_node;
        }
        public static void printList(Node head)
        {
            System.out.println("Linked List");
            while (head != null) {
                System.out.print(" " + head.coeff + "x"
                        + "^" + head.power);
                head = head.next;
            }
        }
    }

    static class Node {
        public int coeff, power;
        public Node next;
        public Node(int coeff, int power)
        {
            this.coeff = coeff;
            this.power = power;
            this.next = null;
        }
    }
}


  