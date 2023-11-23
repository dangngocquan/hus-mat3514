package hw6_21000673_nguyenvandai.exercise6;

public class Order implements Comparable<Order> {
    private String type;
    private int shares;
    private double price;

    public Order(String type, int shares, double price) {
        this.type = type;
        this.shares = shares;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Order other) {
        if (type.equalsIgnoreCase("buy")) {
            return Double.compare(other.price, price);
        } else if (type.equalsIgnoreCase("sell")) {
            return Double.compare(price, other.price);
        }
        return 0;
    }

    @Override
    public String toString() {
        return type + " " + shares + " shares at $" + price + " each";
    }
}