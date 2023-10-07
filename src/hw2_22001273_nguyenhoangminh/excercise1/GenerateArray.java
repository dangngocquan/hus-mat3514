package hw2_22001273_nguyenhoangminh.excercise1;

import java.util.Arrays;
import java.util.Random;

public class GenerateArray {

    // Generate random array
    public static int[] genArray(int length) {
        Random rand = new Random();
        int[] array = new int[length];
        for (int i=0; i<length; ++i) {
            array[i] = rand.nextInt(100000);
        }
        return array;
    }

    // Printing method
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // Printing after each loop method
    public static void displayStats() {
        System.out.println("Number of comparation: " + Sort.numOfCompare);
        System.out.println("Number of swaping: " + Sort.numOfSwap);
    }
}
