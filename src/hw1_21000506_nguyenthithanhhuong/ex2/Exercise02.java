package hw1_21000506_nguyenthithanhhuong.ex2;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define the length of array
        System.out.println("Enter the length of array: ");
        int length = sc.nextInt();

        // Create an array
        int[] array = new int[length];

        System.out.println("Enter the elements of array: ");
        readArray(sc, array);

        // Input array
        System.out.println("Input array: ");
        System.out.println(printArray(array));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Print prime in array
        System.out.println("Primes in input array: ");
        primesInArray(array);

        // Other
        // Print square number in array
        System.out.println("Square numbers in input array: ");
        squareNumbersInArray(array);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Generic

        // Double array
        Double[] array1 = {1.2, 5.9, 6.8, 4.8, 7.3};
        // print array
        System.out.println("Print Double array by generic:");
        System.out.println(printArrayByGeneric(array1));
        // get min element
        System.out.println("Min element of this array: ");
        System.out.println(getMinElementOfArray(array1));

        // String array
        String[] array2 = {"red", "green", "yellow", "blue", "pink"};
        //print array
        System.out.println("Print String array by generic:");
        System.out.println(printArrayByGeneric(array2));
        //get min element
        System.out.println("Min element of this array: ");
        System.out.println(getMinElementOfArray(array2));
    }

    // Check a prime method
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Check prime in an array method
    public static void primesInArray(int[] array) {
        try {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < array.length; i++) {
                if (isPrime(array[i])) {
                    sb.append(array[i]).append(", ");
                }
            }
            System.out.println(sb.substring(0, sb.toString().length() - 2));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Input array doesn't have prime.");
        }
    }

    // Check a square number method
    public static boolean isSquareNumber(int num) {
        double sqNum = Math.sqrt(num);
        return (sqNum - Math.floor(sqNum)) == 0;
    }

    // Check square number in an array method
    public static void squareNumbersInArray(int[] array) {
        try {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < array.length; i++) {
                if (isSquareNumber(array[i])) {
                    sb.append(array[i]).append(", ");
                }
            }
            System.out.println(sb.substring(0, sb.toString().length() - 2));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Input array doesn't have square number.");
        }
    }

    // Read an array by scanner method
    public static void readArray(Scanner sc, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
    }

    // Print an array method
    public static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[array.length - 1]).append("]");
        return sb.toString();
    }

    // Print an array use generic method
    public static <T> String printArrayByGeneric(T[] array) {
        StringBuilder sb = new StringBuilder("[");

        for (T element : array) {
            sb.append(element).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    // Get min element in array use generic
    public static <T extends Comparable<T>> T getMinElementOfArray(T[] array) {
        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) min = element;
        }
        return min;
    }

    //Example run program
    /*
    Enter the length of array:
    6
    Enter the elements of array:
    2 4 3 5 9 10
    Input array:
    [2, 4, 3, 5, 9, 10]
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Primes in input array:
    2, 3, 5
    Square numbers in input array:
    4, 9
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Print Double array by generic:
    [1.2, 5.9, 6.8, 4.8, 7.3]
    Min element of this array:
    1.2
    Print String array by generic:
    [red, green, yellow, blue, pink]
    Min element of this array:
    blue
    */
}
