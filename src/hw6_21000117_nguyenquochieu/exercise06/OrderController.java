package hw6_21000117_nguyenquochieu.exercise06;

import hw6_21000117_nguyenquochieu.exercise02.MinHeapPriorityQueue;

public class OrderController {
    private MinHeapPriorityQueue<Double, Order> buyQueue = new MinHeapPriorityQueue<>();
    private MinHeapPriorityQueue<Double, Order> sellQueue = new MinHeapPriorityQueue<>();

    public OrderController() {
        createSampleOrders();
    }

    private void createSampleOrders() {
        String buyConcept = "VNBUY";
        String sellConcept = "VNSELL";
        for (int i = 0; i < 150; i++) {
            String id = buyConcept;
            if (i >= 100) {
                id += Integer.toString(i);
            } else if (i >= 10) {
                id += "0" + Integer.toString(i);
            } else id += "00" + Integer.toString(i);
            BuyOrder order = new BuyOrder(id);
            buyQueue.insert(order.getPrice(), order);
        }
        for (int i = 0; i < 150; i++) {
            String id = sellConcept;
            if (i >= 100) {
                id += Integer.toString(i);
            } else if (i >= 10) {
                id += "0" + Integer.toString(i);
            } else id += "00" + Integer.toString(i);
            SellOrder order = new SellOrder(id);
            sellQueue.insert(order.getPrice(), order);
        }
        buyQueue.upHeap();
        sellQueue.upHeap();
    }
    public int trade() {
        Order buy = buyQueue.getRootValue();
        Order sell = sellQueue.getRootValue();
        if (buy.getPrice() >= sell.getPrice()) {
            buyQueue.removeMin();
            sellQueue.removeMin();
            buyQueue.downHeap();
            sellQueue.downHeap();
            System.out.println("Exchanged! " + "Buy: " + buy.getId() + " - Sell: " + sell.getId());
            return 0;
        }
        return -1;
    }
}
