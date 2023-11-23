package hw6_21000693_ledinhquangminh.Combo4Advanced;

public class PriorityQueueTest {
    public static void main(String[] args) {
        testIntegerPriorityQueue();
        testProductPriorityQueue();
    }

    private static void testIntegerPriorityQueue() {
        System.out.println("Testing Integer Priority Queue:");
        PriorityQueueInterface<Integer, Integer> pq = new UnsortedArrayPriorityQueue<>();
        pq.insert(5, 50);
        pq.insert(3, 30);
        pq.insert(8, 80);
        pq.insert(2, 20);

        System.out.println("Size: " + pq.size());
        while (!pq.isEmpty()) {
            Entry<Integer, Integer> entry = pq.removeMin();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    private static void testProductPriorityQueue() {
        System.out.println("Testing Product Priority Queue:");
        PriorityQueueInterface<String, Product> pq = new UnsortedArrayPriorityQueue<>();
        pq.insert("apple", new Product("Apple", 1.99));
        pq.insert("banana", new Product("Banana", 0.99));
        pq.insert("orange", new Product("Orange", 2.49));

        System.out.println("Size: " + pq.size());
        while (!pq.isEmpty()) {
            Entry<String, Product> entry = pq.removeMin();
            System.out.println("Key: " + entry.getKey() + ", Product: " + entry.getValue().getName() + " - $" + entry.getValue().getPrice());
        }
    }

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
