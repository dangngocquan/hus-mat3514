package hw6_22001273_nguyenhoangminh.exercise2;

public class Main {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>(9);

        heap.insert(6, "K");
        System.out.println(heap);
        heap.insert(7, "L");
        System.out.println(heap);
        heap.insert(9, "R");
        System.out.println(heap);
        heap.insert(10, "H");
        System.out.println(heap);
        heap.insert(1, "A");
        System.out.println(heap);
        heap.insert(3, "B");
        System.out.println(heap);
        heap.insert(2, "E");
        System.out.println(heap);
        heap.insert(5, "D");

        System.out.println(heap);

        System.out.println(heap.size());

        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());

    }
}
