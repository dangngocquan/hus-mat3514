package hw7_21000699_dangngocquan.exercise001;

import hw7_21000699_dangngocquan.base.list.*;

public class Test {
    public void run() {
        Integer[] data = new Generator().randomArray(10, 0, 10);
        ListInterface<Integer>  unsortedArrList = new UnsortedArrayList<>();
        insertData(unsortedArrList, data);
        testSearchingInList(unsortedArrList);

        ListInterface<Integer>  sortedArrList = new SortedArrayList<>();
        insertData(sortedArrList, data);
        testSearchingInList(sortedArrList);

        ListInterface<Integer>  unsortedLinkedList = new UnsortedLinkedList<>();
        insertData(unsortedLinkedList, data);
        testSearchingInList(unsortedLinkedList);

        ListInterface<Integer>  sortedLinkedList = new SortedLinkedList<>();
        insertData(sortedLinkedList, data);
        testSearchingInList(sortedLinkedList);
    }

    public void testSearchingInList(ListInterface<Integer> list) {
        System.out.println("\nTEST SEARCH " + list.getClass().getSimpleName());
        System.out.println("LIST: " + list);
        testIndexOf(list, 1);
        testIndexOf(list, 0);
        testIndexOf(list, 4);
        testIndexOf(list, 2);
        testIndexOf(list, 3);
    }

    public void testIndexOf(ListInterface<Integer> list, Integer value) {
        System.out.println("Index of value " + value + " is: " + list.indexOf(value));
    }

    public void insertData(ListInterface<Integer> list, Integer[] data) {
        for (Integer e : data) list.add(e);
    }
}
