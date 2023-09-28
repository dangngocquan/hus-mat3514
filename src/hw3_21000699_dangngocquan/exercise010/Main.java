package hw3_21000699_dangngocquan.exercise010;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(10);
        list.addAtHead(11);
        list.addAtHead(12);
        list.addAtHead(13);
        System.out.printf("%-20s: ", "Initial list");
        System.out.println(list);
        // Initial list        : {13, 12, 11, 10}

        System.out.printf("%-20s: ", "Reversed list");
        list.reverse();
        System.out.println(list);
        // Reversed list       : {10, 11, 12, 13}
    }
}
