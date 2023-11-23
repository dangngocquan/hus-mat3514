package hw6_21000117_nguyenquochieu.exercise06;

import java.util.Random;

public class Order {
    protected double price = 0.0;
    protected String id;

    public Order(String id) {
        this.id = id;
    }
    protected double getPrice() {
        Random random = new Random();
        if (price == 0.0) {
            price = random.nextDouble(100.0);
            return price;
        } else {
            price = random.nextDouble(price - 10.0, price + 10.0);
            return price;
        }
    }

    public String getId() {
        return id;
    }
}
