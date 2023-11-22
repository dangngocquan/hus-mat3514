package hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue;

public class TestUnsortedArrayPQ {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> pq = new UnsortedArrayPriorityQueue<>();
        System.out.println(pq.size());
        pq.insert(1, "John");
        pq.insert(3, "Minh");
        pq.insert(8, "Cuong");
        pq.insert(2, "Hai");
        pq.insert(5, "Thai");

        System.out.println(pq);
        pq.removeMin();

        System.out.println(pq);
        pq.removeMin();

        System.out.println(pq);
        pq.removeMin();

        System.out.println(pq);
        pq.removeMin();

        System.out.println(pq);
    }
}
