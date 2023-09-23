package hw1_21000697_lethinhung.ex2;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = sc.nextInt();

        System.out.print("Array: ");
        int[] array = array(length);

        System.out.println("The prime of array: ");
        printPrime(array);

        System.out.println();
        System.out.println("The odd number of array: ");
        printOdd(array);
    }

    public static void printPrime(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static int[] array(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOdd(int n) {
        if (n < 0) {
            return false;
        }
        if (n % 2 == 0) {
            return false;
        }
        return true;
    }

    public static void printOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
