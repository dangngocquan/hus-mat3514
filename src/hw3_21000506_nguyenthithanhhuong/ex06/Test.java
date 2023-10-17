package hw3_21000506_nguyenthithanhhuong.ex06;

public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(2);
        list.addAtHead(3);
        list.addAtTail(1);
        list.addAtTail(5);
        System.out.println(list.toString()); // [3, 2, 1, 5]

        list.addAtIndex(2, 6);
        System.out.println(list.toString()); // [3, 2, 6, 1, 5]

        int elementAtIndex = list.get(3);
        System.out.println(elementAtIndex); // 1

        list.deleteAtIndex(4);
        System.out.println(list.toString()); //[3, 2, 6, 1]
    }
}
