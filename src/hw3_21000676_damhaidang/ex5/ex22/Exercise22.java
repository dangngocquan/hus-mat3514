package hw3_21000676_damhaidang.ex5.ex22;

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
    private int size = 0;
    public LinkedList() {

    }
    public LinkedList(Node node) {
        head = node;
    }

    public void add(int data) {
        Node node = new Node(data);

        if (head == null && tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void add(int position, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else if (position == size - 1) {
            tail.next = newNode;
            tail = newNode;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Exercise22 {
    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            test.add(sc.nextInt());
        }
        int pos = sc.nextInt();
        int data = sc.nextInt();
        test.add(pos, data);
        test.print();
        sc.close();
    }
}