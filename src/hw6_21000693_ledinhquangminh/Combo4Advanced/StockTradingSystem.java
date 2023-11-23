package hw6_21000693_ledinhquangminh.Combo4Advanced;

import java.util.Scanner;

public class StockTradingSystem {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Double, Order> buyOrders = new MinHeapPriorityQueue<>();
        MinHeapPriorityQueue<Double, Order> sellOrders = new MinHeapPriorityQueue<>();

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter stock orders (e.g., 'buy 100 shares at $x' or 'sell 100 shares at $y').");
        System.out.println("Enter 'quit' to exit.");

        while (true) {
            System.out.print("Enter order: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 6 || (!parts[0].equals("buy") && !parts[0].equals("sell") && !parts[1].equals("100") && !parts[3].equals("shares") && !parts[4].equals("at") && !parts[5].startsWith("$"))) {
                System.out.println("Invalid order format. Please use 'buy 100 shares at $x' or 'sell 100 shares at $y'.");
                continue;
            }

            double price = Double.parseDouble(parts[5].substring(1)); // Extract the price

            if (parts[0].equals("buy")) {
                Order buyOrder = new Order(price, OrderType.BUY);
                buyOrders.insert(price, buyOrder);

                // Match buy orders with sell orders
                while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
                    if (buyOrders.min().getKey() >= sellOrders.min().getKey()) {
                        processOrder(buyOrders.removeMin(), sellOrders.removeMin());
                    } else {
                        break;
                    }
                }
            } else if (parts[0].equals("sell")) {
                Order sellOrder = new Order(price, OrderType.SELL);
                sellOrders.insert(price, sellOrder);

                // Match sell orders with buy orders
                while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
                    if (buyOrders.min().getKey() >= sellOrders.min().getKey()) {
                        processOrder(buyOrders.removeMin(), sellOrders.removeMin());
                    } else {
                        break;
                    }
                }
            }
        }
        scanner.close();
    }

    private static void processOrder(Entry<Double, Order> buyOrder, Entry<Double, Order> sellOrder) {
        double buyPrice = buyOrder.getKey();
        double sellPrice = sellOrder.getKey();

        System.out.println("Processed order: Buy at $" + buyPrice + " and Sell at $" + sellPrice);

        // You can perform further processing here, such as updating a trading system's state or recording transactions.
    }
}

class Order {
    private double price;
    private OrderType type;

    public Order(double price, OrderType type) {
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public OrderType getType() {
        return type;
    }
}

enum OrderType {
    BUY,
    SELL
}

