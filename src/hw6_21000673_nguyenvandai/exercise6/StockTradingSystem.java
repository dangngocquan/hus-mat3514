package hw6_21000673_nguyenvandai.exercise6;

import java.util.PriorityQueue;
import java.util.Queue;

public class StockTradingSystem {
    private Queue<Order> buyOrders;
    private Queue<Order> sellOrders;

    public StockTradingSystem() {
        buyOrders = new PriorityQueue<>();
        sellOrders = new PriorityQueue<>();
    }

    public void addOrder(String type, int shares, double price) {
        Order order = new Order(type, shares, price);
        if (type.equalsIgnoreCase("buy")) {
            buyOrders.offer(order);
        } else if (type.equalsIgnoreCase("sell")) {
            sellOrders.offer(order);
        }
        processOrders();
    }

    public void processOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            Order buyOrder = buyOrders.peek();
            Order sellOrder = sellOrders.peek();
            if (sellOrder.getPrice() <= buyOrder.getPrice()) {
                System.out.println("Processed order: " + buyOrder + " and " + sellOrder);
                buyOrders.poll();
                sellOrders.poll();
            } else {
                break;
            }
        }
    }

    public String[] getOrders() {
        String[] orders = new String[buyOrders.size() + sellOrders.size()];
        int i = 0;
        for (Order order : buyOrders) {
            orders[i++] = order.toString();
        }
        for (Order order : sellOrders) {
            orders[i++] = order.toString();
        }
        return orders;
    }
}
