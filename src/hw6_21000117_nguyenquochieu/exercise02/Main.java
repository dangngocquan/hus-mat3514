package hw6_21000117_nguyenquochieu.exercise02;


public class Main {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> priorityQueue = new MinHeapPriorityQueue<>();
        priorityQueue.insert(6, "Nguyen Quoc Hieu");
        priorityQueue.insert(5, "Tran Duy Hung");
        priorityQueue.insert(3, "Cao Tien Dat");
        priorityQueue.insert(4, "Nguyen Van Nam");
        priorityQueue.insert(2, "Ly Thi Binh");
        priorityQueue.upHeap();
        System.out.println("Root of heap: " + priorityQueue.getRoot());
    }
}
