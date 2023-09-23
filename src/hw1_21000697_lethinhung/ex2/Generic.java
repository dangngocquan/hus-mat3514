package hw1_21000697_lethinhung.ex2;

import java.util.Scanner;

public class Generic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = sc.nextInt();

        Integer[] array = new Integer[length];
        System.out.println("Array: ");
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Prime of array: ");
        printPrime(array);
    }

    public static <T> boolean isPrime(T num) {
        if (num instanceof Integer) {
            int n = (Integer) num;
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
        return false;
    }

    public static <T> void printPrime(T[] array) {
        for (T ele : array) {
            if (isPrime(ele)) {
                System.out.print(ele + " ");
            }
        }
    }
}
