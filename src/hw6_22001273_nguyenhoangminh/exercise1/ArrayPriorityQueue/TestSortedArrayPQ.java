package hw6_22001273_nguyenhoangminh.exercise1.ArrayPriorityQueue;

public class TestSortedArrayPQ {
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> pq = new SortedArrayPriorityQueue<>();

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
