package hw3_21000676_damhaidang.ex3;

import java.util.Iterator;
public class Test {
    public static void main(String[] args) {
        ListInterface<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        ((SimpleLinkedList ) list).addBot(11);

        printList(list);
        list.set(10, 12);
        printList(list);

        System.out.println("Co chua so 100 khong? " + list.isContain(100));
        System.out.println("List co trong khong? " + list.isEmpty());
        ((SimpleLinkedList<Integer>) list).removeBot();
        printList(list);
        ((SimpleLinkedList<Integer>) list).removeTop();
        printList(list);
        list.remove(3);
        printList(list);
    }

    public static void printList(ListInterface<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value + " ");
        }
    }
}
