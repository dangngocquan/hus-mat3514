package hw3_21000676_damhaidang.ex5.ex23;

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

    public void deleteAt(int length, int position) {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        if (position == 0) {
            head = head.next;
        } else if (position == length - 1) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
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

public class Exercise23 {
    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            test.add(sc.nextInt());
        }
        int k = sc.nextInt();

        test.deleteAt(length, k);
        test.print();
        sc.close();
    }
}