package hw6_21000685_dinhchinhkhang.Task6;

import hw6_21000685_dinhchinhkhang.Entry;
import hw6_21000685_dinhchinhkhang.Task2.MinHeapPriorityQueue;
import java.util.Scanner;
public class StockOperatingSystem{

    public static class StockOrder implements Comparable<StockOrder> {
        private String type; // Buy or Sell
        private double pricePerShare;
        private int numberShare;

        public StockOrder(String type, double pricePerShare, int numberShare) {
           this.type = type;
           this.pricePerShare = pricePerShare;
           this.numberShare = numberShare;
        }
        public String getType() {
            return type;
        }
        public double getPricePerShare(){
            return pricePerShare;
        }
        public int getNumberShare() {
            return numberShare;
        }

        @Override
        public int compareTo(StockOrder other) {
            if (this.type.equals("Buy")) {
                return Double.compare(other.pricePerShare, this.pricePerShare);
            } else {
                return Double.compare(this.pricePerShare, other.pricePerShare);
            }
        }
        public String toString() {
            return type + "Order - Price: " + pricePerShare + ", Number: " + numberShare;
        }
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue<Double, StockOrder> stockManagementQueue = new MinHeapPriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Input an order(Buy or Sell, price, and number), or exit to stop");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] request = input.split(" ");
            if(request.length == 3) {
                String type = request[0];
                double pricePerShare = Double.parseDouble(request[1]);
                int numberShare = Integer.parseInt(request[2]);

                StockOrder newOrder = new StockOrder(type, pricePerShare, numberShare);
            } else {
                System.out.println("Invalid input, wrong format, format order: (Buy or Sell, price, and number)");
            }
        }
        System.out.println("Order Book: ");
        while(!stockManagementQueue.isEmpty()) {
            Entry<Double, StockOrder> nextOrder = stockManagementQueue.removeMin();
            System.out.println("Price : " + nextOrder.getKey() + ", " +  nextOrder.getValue());
        }
    }
}
