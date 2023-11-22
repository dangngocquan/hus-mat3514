package hw6_21000506_nguyenthithanhhuong.ex01.test_case;

public class Product {
    private String name;
    private int price;

    public Product(int price, String name) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
