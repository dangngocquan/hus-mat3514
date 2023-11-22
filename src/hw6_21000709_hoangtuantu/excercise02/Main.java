package hw6_21000709_hoangtuantu.excercise02;

public class Main {
	public static void main(String[] args) {
		MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>(10);
		heap.insert(9, "Z");
		heap.insert(1, "A");
		heap.insert(2, "B");
		heap.insert(3, "C");
		heap.insert(4, "D");
		heap.insert(5, "E");
        heap.insert(6, "F");
        heap.insert(7, "G");
        heap.insert(8, "H");

		heap.printInOrder();
	}
}
