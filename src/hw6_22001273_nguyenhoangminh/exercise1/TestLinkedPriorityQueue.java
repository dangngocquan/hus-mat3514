package hw6_22001273_nguyenhoangminh.exercise1;

public class TestLinkedPriorityQueue {
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> list = new UnsortedLinkedPriorityQueue<>();
        list.insert(1, "Minh");
        list.insert(3, "Thai");
        list.insert(5, "Cuong");
        list.insert(2, "Bao");
        list.insert(10, "Thu");
        list.insert(8, "Hue");

        System.out.println(list.isEmpty());

        System.out.println(list);

        System.out.println("Min element is " + list.min());

        list.removeMin();
        System.out.println(list);
        list.removeMin();
        System.out.println(list);
        list.removeMin();
        System.out.println(list);

    }
}
