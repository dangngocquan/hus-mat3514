package hw3_21000676_damhaidang.ex5.ex21;

import java.util.Scanner;

class Node {
    Node next = null;
    int data;
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    private Node head = null;
    private Node tail = null;
    public LinkedList() {

    }
    public LinkedList(Node node) {
        head = node;
    }

    public void add(int data) {
        Node node = new Node(data);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Exercise21 {
    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            test.add(sc.nextInt());
        }
        test.print();
        sc.close();
    }
}
