package hw2_21000709_hoangtuantu.exercise04;

import hw2_21000709_hoangtuantu.exercise01.QuickSort;
import hw2_21000709_hoangtuantu.exercise01.SortSolution;

import java.util.Arrays;
import java.util.Random;


public class MinNumberNotAppear {
    static Random random = new Random();

    public static int[] initializeArray(int size){
        int[]  numbers = new int[size];
        for (int i = 0; i < size; i++){
            if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else if (random.nextBoolean()){
                numbers[i] = random.nextInt((int) Math.pow(10, 4));
            } else{
                numbers[i] = 0;
            }
        }
        return numbers;
    }

    public static int solve(int[] numbers){
        if (numbers[0] > 0){
            return 0;
        }
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] - numbers[i - 1] > 1 ){
                return numbers[i - 1] + 1;
            }
        }
        return numbers[numbers.length - 1] + 1;
    }
    public static void main(String[] args) {
        int size = random.nextInt(100) + 1; // initialize size of array
        int[] numbers = initializeArray(size); // initialize array
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(numbers)); // print out input array

        SortSolution solution = new SortSolution();
        solution.setNewSort(new QuickSort(), numbers);
        solution.sort();
        System.out.println("Answer is: " + solve(numbers));

    }
}
