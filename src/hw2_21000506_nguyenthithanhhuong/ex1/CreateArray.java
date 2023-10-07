package hw2_21000506_nguyenthithanhhuong.ex1;

import java.util.Scanner;

public class CreateArray {
    // Create array by keyboard method
    public static void createArrayByKeyboard(Scanner sc, int[] array) {
        int i = 0;
        while (i < array.length) {
            array[i] = sc.nextInt();
            i++;
        }
    }

    // Create random number method
    public static int createRandomNumber() {
        int min = 1;
        int max = 1000000;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // Create random array method
    public static int[] createRandomArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = createRandomNumber();
        }
        return array;
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
}
