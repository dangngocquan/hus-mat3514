package hw6_22001273_nguyenhoangminh.exercise6.tradingstocks;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TradingMarket market = new TradingMarket(100);

        System.out.println("Welcome to trading market simulation!!!");
        System.out.println("Pick an option  (Enter the number only):");
        System.out.println("1. Create buy order.");
        System.out.println("2. Create sell order.");
        System.out.println("3. Exit programme.");

        int option = sc.nextInt();

        while (option != 3) {
            if (option == 1) {
                System.out.println("What price are you looking to buy?");
                double price = sc.nextDouble();
                System.out.println("How many stocks do you want to buy?");
                int buyQuantity = sc.nextInt();

                market.createBuyOrder(price, buyQuantity);

                market.revalidate();
            } else if (option == 2) {
                System.out.println("What price are you looing to sell?");
                double price = sc.nextDouble();
                System.out.println("How many stocks are you looking to sell?");
                int sellQuantity = sc.nextInt();

                market.createSellOrder(price, sellQuantity);

                market.revalidate();
            }

            System.out.println();
            System.out.print("Pick an option:  ");
            System.out.print("1. Create buy order.     ");
            System.out.print("2. Create sell order.      ");
            System.out.println("3. Exit programme.");

            option = sc.nextInt();
        }

        sc.close();
    }
}
