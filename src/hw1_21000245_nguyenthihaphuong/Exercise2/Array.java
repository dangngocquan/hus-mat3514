package hw1_21000245_nguyenthihaphuong.Exercise2;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the integer array: ");
        int n = scanner.nextInt();

        // Create a GenericArray of integers
        GenericArray<Integer> intArray = new GenericArray<>(n);

        System.out.println("Enter a sequence of " + n + " integers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer element " + (i + 1) + ": ");
            intArray.set(i, scanner.nextInt());
        }

        // Create a GenericArray of doubles
        GenericArray<Double> doubleArray = new GenericArray<>(n);

        // Convert and copy integer values to doubleArray
        for (int i = 0; i < n; i++) {
            doubleArray.set(i, (double) intArray.get(i));
        }

        // Create a GenericArray of doubles
        GenericArray<Float> floatArray = new GenericArray<>(n);

        // Convert and copy integer values to doubleArray
        for (int i = 0; i < n; i++) {
            floatArray.set(i, (float) intArray.get(i));
        }

        scanner.close();

        System.out.println("Integer elements in the integer array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(intArray.get(i) + " ");
        }

        // Print the prime numbers in the array
        System.out.println("\nPrime numbers in the array are:");
        for (int i = 0; i < n; i++) {
            if (isPrime(intArray.get(i))) {
                System.out.print(intArray.get(i) + " ");
            }
        }

        System.out.println("\nDouble elements in the double array (converted from integers) are:");
        for (int i = 0; i < n; i++) {
            System.out.print(doubleArray.get(i) + " ");
        }

        System.out.println("\nFloat elements in the float array (converted from integers) are:");
        for (int i = 0; i < n; i++) {
            System.out.print(doubleArray.get(i) + " ");
        }
    }

    // function to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
