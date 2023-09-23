package hw1_21000697_lethinhung;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int: ");
        int a1 = sc.nextInt();
        System.out.println("output: " + a1);

        System.out.print("short: ");
        short a2 = sc.nextShort();
        System.out.println("output: " + a2);

        System.out.print("byte: ");
        byte a3 = sc.nextByte();
        System.out.println("output: " + a3);

        System.out.print("long");
        long b1 = sc.nextLong();
        System.out.println("output: " + b1);

        System.out.print("float: ");
        float b2 = sc.nextFloat();
        System.out.println("output: " + b2);

        System.out.print("double: ");
        double b3 = sc.nextDouble();
        System.out.println("output: " + b3);

        System.out.print("boolean: ");
        boolean c = sc.nextBoolean();
        System.out.println("output: " + c);

        System.out.print("char: ");
        char d = sc.next().charAt(0);
        System.out.println("output: " + d);
    }
}
