package hw2_21000709_hoangtuantu.exercise04;

import hw2_21000709_hoangtuantu.exercise01.QuickSort;
import hw2_21000709_hoangtuantu.exercise01.SortSolution;

import java.util.Random;

public class SortInteger {
    static Random random = new Random();

    public static int[] storeNumber(int[] numbers){
        int[] result = new int[numbers.length];
        int index = 0;
        for (int number : numbers) {
            if (number != 0){
                result[index] = number;
                index++;
            }
        }
        return result;
    }


    /**
     * This function initialize a random array that have positive, negative and zero number.
     *
     * @param size size of array want to initialize
     * @return Integer array
     */
    public static int[] initializeArray(int size){
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt((int)Math.pow(10,6) * 2) - (int) Math.pow(10, 6);
        }
        return array;
    }



    /***
     * This method place number into right place. It places all negative first. Negative number place from last of array, so it will be descending from first of array.
     *
     * @param numbers Origin array
     * @param sorted Array have sorted and all first number are not equal 0
     */
    public static void solve(int[] numbers, int[] sorted){
        int index = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] < 0) {
                numbers[i] = sorted[index];
                index++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                numbers[i] = sorted[index];
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int size = random.nextInt((int) Math.pow(10, 4)) + 1; // Size of array
        int[] numbers = initializeArray(size); // Initialize array

        int[] temp = storeNumber(numbers); // store all non-zero number in firsts element of array

        SortSolution solution = new SortSolution(new QuickSort(), temp, true,false);
        solution.sort(); // Sorting Array

        solve(numbers, temp); // Place number into right array

        solution.setNumbers(numbers);
        System.out.println(solution); // print out result
    }
}
