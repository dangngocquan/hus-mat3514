package hw1_21000245_nguyenthihaphuong.Exercise1;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a string
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        scanner.close();

        // Convert the string to int (if possible)
        try {
            int intValue = Integer.parseInt(input);
            System.out.println("Value as int: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to int.");
        }

        // Convert the string to double (if possible)
        try {
            double doubleValue = Double.parseDouble(input);
            System.out.println("Value as double: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to double.");
        }

        // Convert the string to boolean (if possible)
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            boolean booleanValue = Boolean.parseBoolean(input);
            System.out.println("Value as boolean: " + booleanValue);
        } else {
            System.out.println("Cannot convert to boolean.");
        }

        // Convert the string to char (if it has only one character)
        if (input.length() == 1) {
            char charValue = input.charAt(0);
            System.out.println("Value as char: " + charValue);
        } else {
            System.out.println("Cannot convert to char.");
        }

        // Convert the string to byte (if possible)
        try {
            byte byteValue = Byte.parseByte(input);
            System.out.println("Value as byte: " + byteValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to byte.");
        }

        // Convert the string to short (if possible)
        try {
            short shortValue = Short.parseShort(input);
            System.out.println("Value as short: " + shortValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to short.");
        }

        // Convert the string to long (if possible)
        try {
            long longValue = Long.parseLong(input);
            System.out.println("Value as long: " + longValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to long.");
        }

        // Convert the string to float (if possible)
        try {
            float floatValue = Float.parseFloat(input);
            System.out.println("Value as float: " + floatValue);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to float.");
        }
    }
}
