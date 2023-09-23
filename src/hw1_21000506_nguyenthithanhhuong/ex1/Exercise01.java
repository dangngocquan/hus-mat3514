package hw1_21000506_nguyenthithanhhuong.ex1;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and print byte value
        System.out.print("Enter byte value: ");
        byte byteValue = sc.nextByte();
        System.out.println("Byte value has been entered: " + byteValue);

        // Read and print short value
        System.out.print("Enter short value: ");
        short shortValue = sc.nextShort();
        System.out.println("Short value has been entered: " + shortValue);

        // Read and print int value
        System.out.print("Enter int value: ");
        int intValue = sc.nextInt();
        System.out.println("Int value has been entered: " + intValue);

        // Read and print long value
        System.out.print("Enter long value: ");
        long longValue = sc.nextLong();
        System.out.println("Long value has been entered: " + longValue);

        // Read and print float value
        System.out.print("Enter float value: ");
        float floatValue = sc.nextFloat();
        System.out.println("Float value has been entered: " + floatValue);

        // Read and print double value
        System.out.print("Enter double value: ");
        double doubleValue = sc.nextDouble();
        System.out.println("Double value has been entered: " + doubleValue);

        // Read and print boolean value
        System.out.print("Enter boolean value: ");
        boolean boolValue = sc.nextBoolean();
        System.out.println("Boolean value has been entered: " + boolValue);

        // Read and print character value
        System.out.print("Enter character value: ");
        char charValue = sc.next().charAt(0);
        System.out.println("Character value has been entered: " + charValue);

        sc.close();
    }

    // Example run program
    /*
    Enter byte value: 104
    Byte value has been entered: 104
    Enter short value: 1004
    Short value has been entered: 1004
    Enter int value: 1812
    Int value has been entered: 1812
    Enter long value: 18122003
    Long value has been entered: 18122003
    Enter float value: 1004.1812
    Float value has been entered: 1004.1812
    Enter double value: 15.09
    Double value has been entered: 15.09
    Enter boolean value: true
    Boolean value has been entered: true
    Enter character value: h
    Character value has been entered: h
     */
}
