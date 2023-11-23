package hw6_21000685_dinhchinhkhang.Task1;

public class Test {
    public static void main(String[] args) {

        // a) Gia trị phần tử làm khóa
        UnsortedArrayPriorityQueue<Integer, Integer> queueA = new UnsortedArrayPriorityQueue<>();
        SortedArrayPrimaryQueue<Integer, Integer> queueB = new SortedArrayPrimaryQueue<>();
        UnsortedLinkedPriorityQueue<Integer, Integer> queueC = new UnsortedLinkedPriorityQueue<>();
        SortedLinkedPriorityQueue<Integer, Integer> queueD = new SortedLinkedPriorityQueue<>();

        // b) Gía trị và khóa khác nhau
        UnsortedArrayPriorityQueue<Double, String> queueA1 = new UnsortedArrayPriorityQueue<>();
        SortedArrayPrimaryQueue<Double, String> queueB1 = new SortedArrayPrimaryQueue<>();
        UnsortedLinkedPriorityQueue<Double, String> queueC1 = new UnsortedLinkedPriorityQueue<>();
        SortedLinkedPriorityQueue<Double, String> queueD1 = new SortedLinkedPriorityQueue<>();

        // Test UnsortedArrayPriorityQueue
        //a
        queueA.insert(1, 0);
        queueA.insert(2, 5);
        queueA.insert(3, 8);
        System.out.println(queueA.size());
        System.out.println(queueA.isEmpty());
        System.out.println(queueA.min());
        System.out.println();
        //b
        queueA1.insert(100.0, "A");
        queueA1.insert(200.0, "B");
        queueA1.insert(300.0, "C");
        System.out.println(queueA1.size());
        System.out.println(queueA1.isEmpty());
        System.out.println(queueA1.min());
        System.out.println();

        // Test SortedArrayPriorityQueue
        //a
        queueB.insert(1, 1);
        queueB.insert(4, 2);
        queueB.insert(6, 5);
        System.out.println(queueB.size());
        System.out.println(queueB.isEmpty());
        System.out.println(queueB.min());
        System.out.println();
        //b
        queueB1.insert(150.0, "A1");
        queueB1.insert(210.0, "B1");
        queueB1.insert(330.0, "C1");
        System.out.println(queueB1.size());
        System.out.println(queueB1.isEmpty());
        System.out.println(queueB1.min());
        System.out.println();

        // Test UnsortedLinkedPriorityQueue
        //a
        queueC.insert(2, 10);
        queueC.insert(3, 20);
        queueC.insert(5, 30);
        System.out.println(queueC.size());
        System.out.println(queueC.isEmpty());
        System.out.println(queueC.min());
        System.out.println();
        //b
        queueC1.insert(185.0, "AB");
        queueC1.insert(212.0, "ABC");
        queueC1.insert(434.0, "ABCD");
        System.out.println(queueC1.size());
        System.out.println(queueC1.isEmpty());
        System.out.println(queueC1.min());
        System.out.println();

        // Test SortedLinkedPriorityQueue
        //a
        queueD.insert(11, 101);
        queueD.insert(12, 202);
        queueD.insert(15, 303);
        System.out.println(queueD.size());
        System.out.println(queueD.isEmpty());
        System.out.println(queueD.min());
        System.out.println();
        //b
        queueD1.insert(12.0, "M");
        queueD1.insert(212.0, "Y");
        queueD1.insert(1212.0, "T");
        System.out.println(queueD1.size());
        System.out.println(queueD1.isEmpty());
        System.out.println(queueD1.min());
    }
}

