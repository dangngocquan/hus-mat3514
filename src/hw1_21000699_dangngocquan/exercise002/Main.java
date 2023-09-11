package hw1_21000699_dangngocquan.exercise002;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input
        System.out.print("Enter length of array: ");
        int n = scanner.nextInt();
        System.out.print("Min value of element: ");
        int from = scanner.nextInt();
        System.out.print("Max value of element: ");
        int to = scanner.nextInt()+1;

        // Create random array
        int[] elements = createRandomArrayInteger(n, from, to);
        System.out.println("\nRandom array:\n" + arrayToString(elements));

        // Get prime numbers in array
        int[] primes = getPrimesOfArray(elements);
        System.out.println("Primes:\n" + arrayToString(primes));

        // Get even number in array
        int[] evens = getEvenNumbersOfArray(elements);
        System.out.println("Even numbers:\n" + arrayToString(evens));

        scanner.close();
    }

    // Get random integer in [from, to-1]
    public static int createRandomInteger(int from, int to) {
        long range = (long) (to) - (long) (from);
        int randomNumber = (int) (Math.random() * range + (long) (from));
        return randomNumber;
    }


    // Create random array with length 'n'
    // Each element has random value in [from, to-1]
    public static int[] createRandomArrayInteger(int length, int from, int to) {
        int[] elements = new int[length];
        for (int i = 0; i < length; i++) {
            elements[i] = createRandomInteger(from, to);
        }
        return elements;
    }

    // Array to String
    public static String arrayToString(int[] elements) {
        StringBuilder sb = new StringBuilder("[");
        for (int element : elements) sb.append(element).append(", ");
        if (sb.length() > 1) sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }


    // Check prime number
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }


    // Get array of prime number in input array
    public static int[] getPrimesOfArray(int[] elements) {
        List<Integer> list = new LinkedList<>();
        for (int element : elements) {
            if (isPrime(element)) list.add(element);
        }
        int[] primes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) primes[i] = list.get(i);
        return primes;
    }


    // Get array of even number in input array
    public static int[] getEvenNumbersOfArray(int[] elements) {
        List<Integer> list = new LinkedList<>();
        for (int element : elements) {
            if (element % 2 == 0) list.add(element);
        }
        int[] evens = new int[list.size()];
        for (int i = 0; i < list.size(); i++) evens[i] = list.get(i);
        return evens;
    }


//    // Get positive number of array use 'generic'
//    public static <T extends Comparable<T>> T[] getPositiveNumbersOfArray(T[] elements) {
//        List<T> list = new LinkedList<T>();
//        for (T element : elements) {
//
//        }
//    }

}
