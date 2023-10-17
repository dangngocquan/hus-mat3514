package hw3_21000676_damhaidang.ex2;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ListInterface<Integer> list = new SimpleArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        printList(list);
        list.set(0, 10);
        printList(list);
        list.remove(4);
        printList(list);
        System.out.println("Co chua so 100 khong? " + list.isContain(100));
        System.out.println("List co trong khong? " + list.isEmpty());
        
    }
    public static void printList(ListInterface<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
