package hw3_21000699_dangngocquan.exercise004;

import hw3_21000699_dangngocquan.exercise004.models.MyArrayList;
import hw3_21000699_dangngocquan.exercise004.models.MyLinkedList;
import hw3_21000699_dangngocquan.exercise004.models.MyList;
import hw3_21000699_dangngocquan.exercise004.models.WordCount;
import hw3_21000699_dangngocquan.exercise004.services.Service;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        testCountWords();
    }

    public static void testMyLinkedList() {
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        System.out.println(myLinkedList); // {1, 2, 3, 4}
        System.out.println(myLinkedList.get(1)); // 2
        myLinkedList.set(1, 5);
        System.out.println(myLinkedList); // {1, 5, 3, 4}
        myLinkedList.remove(3); // {1, 5, 4}
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.isContain(1)); // true
        System.out.println(myLinkedList.isContain(3)); // false
    }

    public static void testMyArrayList() {
        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        System.out.println(myArrayList); // {1, 2, 3, 4}
        System.out.println(myArrayList.get(1)); // 2
        myArrayList.set(1, 5);
        System.out.println(myArrayList); // {1, 5, 3, 4}
        myArrayList.remove(3); // {1, 5, 4}
        System.out.println(myArrayList);
        System.out.println(myArrayList.isContain(1)); // true
        System.out.println(myArrayList.isContain(3)); // false
    }

    public static void testSortMyLinkedList() {
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(3);
        System.out.println(myLinkedList); // {1, 4, 2, 3}
        Service.sortList(myLinkedList);
        System.out.println(myLinkedList); // {1, 2, 3, 4}
    }

    public static void testSortMyArrayList() {
        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(4);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println(myArrayList); // {1, 4, 2, 3}
        Service.sortList(myArrayList);
        System.out.println(myArrayList); // {1, 2, 3, 4}
    }

    public static void testCountWords() {
        String document = "This is a test count words. Test count word ...";
        MyList<WordCount> listWord = Service.getListWord(document);
        Service.sortList(listWord);
        Iterator<WordCount> iterator = listWord.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
