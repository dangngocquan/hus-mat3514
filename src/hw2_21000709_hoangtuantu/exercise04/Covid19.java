package hw2_21000709_hoangtuantu.exercise04;

import hw2_21000709_hoangtuantu.exercise01.QuickSort;
import hw2_21000709_hoangtuantu.exercise01.SortSolution;

import java.util.Arrays;
import java.util.Random;


public class Covid19 {
    static Random random = new Random();

    public static int[] inputArray(int size){
        int[]  numbers = new int[size];
        for (int i = 0; i < size; i++){
            numbers[i] = random.nextInt((int) Math.pow(10, 9));
        }
        return numbers;
    }

    public static int solve(int[] numbers, int distance){
        SortSolution solution = new SortSolution();
        solution.setNewSort(new QuickSort(), numbers);
        solution.sort();

        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++){
            if (numbers[i + 1] - numbers[i] > distance){
                count++;
            }

        }
        return count + 1;
    }

    public static void main(String[] args) {
        int size = random.nextInt((int) Math.pow(10, 5)) + 1; // initialize size of array
        int[] numbers = inputArray(size); // initialize array
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(numbers)); // print out input array
        int distance = random.nextInt((int) Math.pow(10, 5)) + 1;
        System.out.println("Distance: " + distance);
        System.out.println("Answer is: ");
        System.out.println((solve(numbers, distance)));
    }
}