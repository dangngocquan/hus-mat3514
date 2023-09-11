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
        // Example:
        // Enter length of array: 10
        // Min value of element: 10
        // Max value of element: 100

        // Create random array
        Integer[] elements = createRandomArrayInteger(n, from, to);
        System.out.println("\nRandom array:\n" + arrayToString(elements));
        // Output
        // Random array:
        // [27, 10, 12, 72, 57, 25, 95, 25, 89, 11]

        // Get prime numbers in array
        Integer[] primes = getPrimesOfArray(elements);
        System.out.println("Primes:\n" + arrayToString(primes));
        // Output
        // Primes:
        // [89, 11]

        // Different condition
        // Get even number in array
        Integer[] evens = getEvenNumbersOfArray(elements);
        System.out.println("Even numbers:\n" + arrayToString(evens));
        // Output
        // Even numbers:
        // [10, 12, 72]

        // Use generic to get maximum value in array
        Double[] array01 = new Double[] {1.2, 4.5, 2.3, 3.4};
        System.out.printf("\nArray 1: %s\nMaximum element: %s\n",
                arrayToString(array01),
                getMaximumElement(array01));
        // Output
        // Array 1: [1.2, 4.5, 2.3, 3.4]
        // Maximum element: 4.5

        String[] array02 = new String[] {"abcd", "abef", "cdef", "mnpq"};
        System.out.printf("\nArray 2: %s\nMaximum element: %s\n",
                arrayToString(array02),
                getMaximumElement(array02));
        // Output
        // Array 2: [abcd, abef, cdef, mnpq]
        // Maximum element: mnpq


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
    public static Integer[] createRandomArrayInteger(int length, int from, int to) {
        Integer[] elements = new Integer[length];
        for (int i = 0; i < length; i++) {
            elements[i] = createRandomInteger(from, to);
        }
        return elements;
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
    public static Integer[] getPrimesOfArray(Integer[] elements) {
        List<Integer> list = new LinkedList<>();
        for (int element : elements) {
            if (isPrime(element)) list.add(element);
        }
        Integer[] primes = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) primes[i] = list.get(i);
        return primes;
    }


    // Get array of even number in input array
    public static Integer[] getEvenNumbersOfArray(Integer[] elements) {
        List<Integer> list = new LinkedList<>();
        for (int element : elements) {
            if (element % 2 == 0) list.add(element);
        }
        Integer[] evens = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) evens[i] = list.get(i);
        return evens;
    }

    // Use generic, get maximum element of input array
    // Type of value element in array can be String, Double, ...
    public static <T extends Comparable<T>> T getMaximumElement(T[] elements) {
        if (elements.length == 0) return null;
        T maximum = elements[0];
        for (T element : elements) {
            if (element.compareTo(maximum) > 0) maximum = element;
        }
        return maximum;
    }

    // Use generic to convert an array to string
    // Array to String
    public static <T> String arrayToString(T[] elements) {
        StringBuilder sb = new StringBuilder("[");
        for (T element : elements) sb.append(element.toString()).append(", ");
        if (sb.length() > 1) sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

}
