package hw2_21000506_nguyenthithanhhuong.ex2;

import java.util.Scanner;

public class CreateArray {
    // Create Integer array by keyboard method
    public static void createIntegerArrayByKeyboard(Scanner sc, Integer[] array) {
        int i = 0;
        while (i < array.length) {
            array[i] = sc.nextInt();
            i++;
        }
    }

    // Create random number method
    public static int createIntegerRandomNumber() {
        int min = 1;
        int max = 1000000;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // Create Integer random array method
    public static Integer[] createIntegerRandomArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = createIntegerRandomNumber();
        }
        return array;
    }

    // Print an array method
    public static <T extends Comparable<T>> String printArray(T[] array) {
        StringBuilder sb = new StringBuilder("[");

        for (T element : array) {
            sb.append(element).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }
}
