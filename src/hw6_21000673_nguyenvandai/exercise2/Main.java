package hw6_21000673_nguyenvandai.exercise2;

public class Main {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> queue = new MinHeapPriorityQueue<>();
        // Thêm các phần tử vào hàng đợi
        queue.insert(4, "Four");
        queue.insert(2, "Two");
        queue.insert(6, "Six");
        queue.insert(1, "One");
        queue.insert(5, "Five");
        queue.insert(3, "Three");
        System.out.println(queue.size);
        // In ra các phần tử và xóa phần tử nhỏ nhất
        while (!queue.isEmpty()) {
            // các phần tử được thêm vào hàng đợi với giá trị khoá tăng dần từ 1 đến 6 và được xóa theo thứ tự tăng dần
            System.out.println(queue.removeMin());
        }
        System.out.println(queue.size);
    }
}
