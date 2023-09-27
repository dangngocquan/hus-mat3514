package hw1_21002169_nguyenngocquy;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Kieu so nguyen
        System.out.print("Nhap so nguyen: ");
        int integerNumber = sc.nextInt();
        System.out.println("So nguyen: " + integerNumber);

        // Kieu so thuc
        System.out.print("Nhap so thuc: ");
        double doubleNumber = sc.nextDouble();
        System.out.println("So thuc: " + doubleNumber);

        // Kieu ki tu
        System.out.print("Nhap ki tu: ");
        char character = sc.next().charAt(0);
        System.out.println("Ki tu: " + character);

        // Kieu boolean
        System.out.print("Nhap gia tri boolean: ");
        boolean booleanValue = sc.nextBoolean();
        System.out.println("Gia tri boolean: " + booleanValue);

        sc.close();
    }
}